package sync.spctrum.apispring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.service.receita.ReceitaService;
import sync.spctrum.apispring.service.receita.dto.modelMapper.ReceitaMapper;
import sync.spctrum.apispring.service.receita.dto.receita.ReceitaResponseDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/openai")
@SecurityRequirement(name = "Bearer")
public class OpenAiController {

    private final ReceitaRepository receitaRepository;
    private final ReceitaService receitaService;
    private final OpenAiChatClient openai;

    @Autowired
    public OpenAiController(ReceitaRepository receitaRepository, ReceitaService receitaService, OpenAiChatClient openai) {
        this.receitaRepository = receitaRepository;
        this.receitaService = receitaService;
        this.openai = openai;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ReceitaResponseDTO>> getReceitasIdUsuario(@PathVariable Long id) {
        List<ReceitaResponseDTO> receitas = ReceitaMapper.toListRespostaDTO(receitaService.findByReceitasWhereUsuarioId(id));

        if (receitas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(receitas);
    }


    @GetMapping("/gpt3/{id}")
    public List<Receita> gpt3(@RequestParam String objetivo, @RequestParam Integer qtdSelecionada, @PathVariable Long id) {
        String prompt = "Gere um JSON com os seguintes campos Nome, Ingredientes, Modo de preparo, Calorias, Tempo de preparo, Tipo, Proteina, Calorias, Carboidratos, Gorduras, Acucar. " +
                "O JSON deve ser com o [] e ' , ' para separar, o campo Ingredientes seja representado como um array com os ingredientes listados individualmente. " +
                "Meu objetivo é " + objetivo + " . Gere somente o texto e sem nenhum texto explicativo, gere 5 receitas diferentes.";

        String resposta;
        try {
            resposta = openai.call(prompt);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar a API OpenAI", e);
        }

        List<Receita> receitas;
        try {
            receitas = receitaService.desserializarListaReceitas(resposta, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao desserializar a resposta da API OpenAI", e);
        }
        receitas.forEach(r -> {
            r.setDataCriacao(LocalDate.now());
            r.setQtdSelecionada(qtdSelecionada);
        });

        receitaRepository.saveAll(receitas);

        return receitas;
    }


    @GetMapping("/receita-extra/{id}")
    public ReceitaResponseDTO receitaExtra(@RequestParam String acompanhamento, @RequestParam String principal, @PathVariable Long id) {
        String prompt = "Gere um JSON com os seguintes campos Nome, Ingredientes, Modo de preparo, Calorias, Tempo de preparo, Tipo, Proteina, Calorias, Carboidratos, Gorduras, Acucar. " +
                "O JSON deve ser com o [] e ' , ' para separar, o campo Ingredientes seja representado como um array com os ingredientes listados individualmente. " +
                "Deve ser uma receita leve tendo como alimento principal " + principal + " e o acompanhamento é " + acompanhamento + "  . Gere somente o texto e sem nenhum texto explicativo, gere 1 receita";

        String resposta;
        try {
            resposta = openai.call(prompt);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar a API OpenAI", e);
        }

        ReceitaResponseDTO receita;
        try {
            receita = ReceitaMapper.toRespostaDTO(receitaService.desserializarReceitaExtra(resposta, id));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao desserializar a resposta da API OpenAI", e);
        }
        return receita;
    }
}
