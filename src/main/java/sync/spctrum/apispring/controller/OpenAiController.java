package sync.spctrum.apispring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.service.receita.ReceitaService;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/openai")
@SecurityRequirement(name = "Bearer")
public class OpenAiController {
    @Autowired
    ReceitaRepository ReceitaRepository;

    @Autowired
    ReceitaService receitaService;
    
    @Autowired
    OpenAiChatClient openai;

    @GetMapping("/gpt3/{id}")
    public List<Receita> gpt3(@RequestParam String objetivo, @PathVariable Long id) {
        String resposta = openai.call("Gere um JSON com os seguintes campos Nome, Ingredientes, Modo de preparo, Calorias, Tempo de preparo, Tipo, Proteina, Calorias, Carboidratos, Gorduras, Acucar. O JSON deve ser com o [] e ' , ' para separar, o campo Ingredientes seja representado como um array com os ingredientes listados individualmente.  Meu objetivo é " + objetivo + " . Gere somente o texto e sem nenhum texto explicativo, gere 5 receitas diferentes.");

        List<Receita> receitas = receitaService.desserializarListaReceitas(resposta, id);

        ReceitaRepository.saveAll(receitas);
        
        return receitas;
    }
}
