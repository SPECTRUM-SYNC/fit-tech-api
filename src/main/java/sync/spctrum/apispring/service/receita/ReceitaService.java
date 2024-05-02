package sync.spctrum.apispring.service.receita;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import sync.spctrum.apispring.domain.Receita.Receita;

import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ReceitaService {

    private final Gson gson;

    public ReceitaService(Gson gson) {
        this.gson = gson;
    }

    public Receita desserializarReceita(String json) {
        return gson.fromJson(json, Receita.class);
    }
    
    public List<Receita> desserializarListaReceitas(String json) {
        System.out.println("JSON");
        System.out.println("JSON");
        System.out.println("JSON");
        System.out.println("JSON");

        System.out.println(json);


        Type listType = new TypeToken<List<Receita>>(){}.getType();
        return gson.fromJson(json, listType);
    }

}
