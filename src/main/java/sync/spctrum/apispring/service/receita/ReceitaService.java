package sync.spctrum.apispring.service.receita;

import com.google.gson.Gson;

import sync.spctrum.apispring.domain.Receita.Receita;

import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    private final Gson gson;

    public ReceitaService(Gson gson) {
        this.gson = gson;
    }

    public Receita desserializarReceita(String json) {
        return gson.fromJson(json, Receita.class);
    }
}
