package sync.spctrum.apispring.service.receita;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final UsuarioRepository usuarioRepository;
    private final ReceitaRepository receitaRepository;
    private final Gson gson;

    public Receita desserializarReceita(String json) {
        return gson.fromJson(json, Receita.class);
    }

    public List<Receita> desserializarListaReceitas(String json) {
        Type listType = new TypeToken<List<Receita>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    public List<Receita> desserializarListaReceitas(String json, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
        UsuarioResponseDTO response = UsuarioMapper.toRespostaDTO(usuario);
        List<Receita> receitas = desserializarListaReceitas(json);

        if (receitas.isEmpty()) {
            throw new ResourceNotFound("Nenhuma receita encontrada para o JSON fornecido");
        }

        for (Receita receita : receitas) {
            receita.setUsuario(UsuarioMapper.toEntity(response));
        }
        return receitas;
    }
    public Receita desserializarReceitaExtra(String json, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
        UsuarioResponseDTO response = UsuarioMapper.toRespostaDTO(usuario);

        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
        if (jsonArray.isEmpty()) {
            throw new ResourceNotFound("Nenhum objeto encontrado no JSON fornecido");
        }

        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
        Receita receita = gson.fromJson(jsonObject, Receita.class);

        receita.setDataCriacao(LocalDate.now());
        receita.setUsuario(UsuarioMapper.toEntity(response));
        receita.setQtdSelecionada(1);

        return receitaRepository.save(receita);
    }


    public List<Receita> findByReceitasWhereUsuarioId(Long id) {
        return receitaRepository.findAllByUsuario_IdAndDataCriacao(id, LocalDate.now());
    }
}
