package sync.spctrum.apispring.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.service.receita.ReceitaService;

@ContextConfiguration(classes = {OpenAiController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OpenAiControllerTest {
    @MockBean
    private OpenAiChatClient openAiChatClient;

    @Autowired
    private OpenAiController openAiController;

    @MockBean
    private ReceitaRepository receitaRepository;

    @MockBean
    private ReceitaService receitaService;

    /**
     * Method under test: {@link OpenAiController#gpt3(String, Long)}
     */
    @Test
    void testGpt3() throws Exception {
        // Arrange
        when(receitaRepository.saveAll(Mockito.<Iterable<Receita>>any())).thenReturn(new ArrayList<>());
        when(openAiChatClient.call(Mockito.<String>any())).thenReturn("Call");
        when(receitaService.desserializarListaReceitas(Mockito.<String>any(), Mockito.<Long>any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/openai/gpt3/{id}", 1L)
                .param("objetivo", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }
}
