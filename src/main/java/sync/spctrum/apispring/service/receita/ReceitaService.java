package sync.spctrum.apispring.service.receita;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ReceitaService {
    @Autowired
    UsuarioRepository usuarioRepository;

    private final Gson gson;

    public ReceitaService(Gson gson) {
        this.gson = gson;
    }

    public Receita desserializarReceita(String json) {
        return gson.fromJson(json, Receita.class);
    }
    
    public List<Receita> desserializarListaReceitas(String json) {
        System.out.println("JSON");
        System.out.println(json);


        Type listType = new TypeToken<List<Receita>>(){}.getType();
        return gson.fromJson(json, listType);
    }

    public List<Receita> desserializarListaReceitas(String json, Long id) {
        UsuarioResponseDTO response = UsuarioMapper.toRespostaDTO(usuarioRepository.findById(id).orElse(null));
        List<Receita> receitas = desserializarListaReceitas(json);

        if(response == null || receitas.isEmpty()) {
            throw new ResourceNotFound("ID : " + id);
        }

        for(Receita r : receitas) {
            r.setUsuario(UsuarioMapper.toEntity(response));
        }
        return receitas;
    }
}
