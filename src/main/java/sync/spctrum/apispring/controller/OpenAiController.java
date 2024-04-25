package sync.spctrum.apispring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ai.chat.ChatClient;
@RestController
@RequestMapping("/openai")
public class OpenAiController {
    @Autowired
    OpenAiChatClient openai;
    
    @GetMapping("/gpt3")
    public String gpt3(@RequestParam(value = "message", defaultValue = "arroz receita") String message) {
        String script = """
            quero que você gera uma receita com todos micros e macros nutrientes e me retorne em JSON para uma pessoa que : %s.
            gere somente o json, não precisa do texto dizendo a execução            
                """.format(message);
        String resposta = openai.call(script);
        return resposta;
    }
}
