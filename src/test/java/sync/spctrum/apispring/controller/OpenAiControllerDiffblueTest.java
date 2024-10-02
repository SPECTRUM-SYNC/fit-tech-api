package sync.spctrum.apispring.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.receita.ReceitaService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OpenAiController.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class OpenAiControllerDiffblueTest {
    @MockBean
    private OpenAiChatClient openAiChatClient;

    @Autowired
    private OpenAiController openAiController;

    @MockBean
    private ReceitaRepository receitaRepository;

    @MockBean
    private ReceitaService receitaService;

    /**
     * Method under test: {@link OpenAiController#getReceitasIdUsuario(Long)}
     */
    @Test
    void testGetReceitasIdUsuario() throws Exception {
        // Arrange
        when(receitaService.findByReceitasWhereUsuarioId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/openai/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link OpenAiController#getReceitasIdUsuario(Long)}
     */
    @Test
    void testGetReceitasIdUsuario2() throws Exception {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Receita receita = new Receita();
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        receita.setImage("Image");
        receita.setIngredientes(new String[]{"Ingredientes"});
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setQtdSelecionada(1);
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
        receita.setUsuario(usuario2);

        ArrayList<Receita> receitaList = new ArrayList<>();
        receitaList.add(receita);
        when(receitaService.findByReceitasWhereUsuarioId(Mockito.<Long>any())).thenReturn(receitaList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/openai/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<List><item><id>1</id><nome>Nome</nome><ingredientes><ingredientes>Ingredientes</ingredientes><"
                                + "/ingredientes><modoPreparo>Modo Preparo</modoPreparo><calorias>Calorias</calorias><tempoPreparo>Tempo"
                                + " Preparo</tempoPreparo><tipo>Tipo</tipo><proteina>Proteina</proteina><carboidratos>Carboidratos<"
                                + "/carboidratos><gorduras>Gorduras</gorduras><acucar>Acucar</acucar><qtdSelecionada>1</qtdSelecionada>"
                                + "<image>Image</image></item></List>"));
    }

    /**
     * Method under test: {@link OpenAiController#getReceitasIdUsuario(Long)}
     */
    @Test
    void testGetReceitasIdUsuario3() throws Exception {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Receita receita = new Receita();
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        receita.setImage("Image");
        receita.setIngredientes(new String[]{"Ingredientes"});
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setQtdSelecionada(1);
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
        receita.setUsuario(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(0);
        usuario3.setContaAtiva(false);
        usuario3.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("john.smith@example.org");
        usuario3.setGenero("42");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(2L);
        usuario3.setImg("42");
        usuario3.setMeta("42");
        usuario3.setNivelCondicao("42");
        usuario3.setNome("42");
        usuario3.setObjetivo(new Objetivo());
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(0);
        usuario3.setSenha("42");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(2L);
        objetivo2.setObjetivo("42");
        objetivo2.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(0);
        usuario4.setContaAtiva(false);
        usuario4.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("john.smith@example.org");
        usuario4.setGenero("42");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(2L);
        usuario4.setImg("42");
        usuario4.setMeta("42");
        usuario4.setNivelCondicao("42");
        usuario4.setNome("42");
        usuario4.setObjetivo(objetivo2);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(0);
        usuario4.setSenha("42");

        Receita receita2 = new Receita();
        receita2.setAcucar("42");
        receita2.setCalorias("42");
        receita2.setCarboidratos("42");
        receita2.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita2.setGorduras("42");
        receita2.setId(2L);
        receita2.setImage("42");
        receita2.setIngredientes(new String[]{"Ingredientes"});
        receita2.setModoPreparo("42");
        receita2.setNome("42");
        receita2.setProteina("42");
        receita2.setQtdSelecionada(0);
        receita2.setTempoPreparo("42");
        receita2.setTipo("42");
        receita2.setUsuario(usuario4);

        ArrayList<Receita> receitaList = new ArrayList<>();
        receitaList.add(receita2);
        receitaList.add(receita);
        when(receitaService.findByReceitasWhereUsuarioId(Mockito.<Long>any())).thenReturn(receitaList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/openai/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>2</id><nome>42</nome><ingredientes><ingredientes>Ingredientes</ingredientes></ingredientes"
                                        + "><modoPreparo>42</modoPreparo><calorias>42</calorias><tempoPreparo>42</tempoPreparo><tipo>42</tipo>"
                                        + "<proteina>42</proteina><carboidratos>42</carboidratos><gorduras>42</gorduras><acucar>42</acucar>"
                                        + "<qtdSelecionada>0</qtdSelecionada><image>42</image></item><item><id>1</id><nome>Nome</nome><ingredientes"
                                        + "><ingredientes>Ingredientes</ingredientes></ingredientes><modoPreparo>Modo Preparo</modoPreparo>"
                                        + "<calorias>Calorias</calorias><tempoPreparo>Tempo Preparo</tempoPreparo><tipo>Tipo</tipo><proteina"
                                        + ">Proteina</proteina><carboidratos>Carboidratos</carboidratos><gorduras>Gorduras</gorduras><acucar"
                                        + ">Acucar</acucar><qtdSelecionada>1</qtdSelecionada><image>Image</image></item></List>"));
    }

    /**
     * Method under test: {@link OpenAiController#getReceitasIdUsuario(Long)}
     */
    @Test
    void testGetReceitasIdUsuario4() throws Exception {
        // Arrange
        when(receitaService.findByReceitasWhereUsuarioId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link OpenAiController#gpt3(String, Integer, Long)}
     */
    @Test
    void testGpt3() throws Exception {
        // Arrange
        when(receitaRepository.saveAll(Mockito.<Iterable<Receita>>any())).thenReturn(new ArrayList<>());
        when(receitaService.desserializarListaReceitas(Mockito.<String>any(), Mockito.<Long>any()))
                .thenReturn(new ArrayList<>());
        when(openAiChatClient.call(Mockito.<String>any())).thenReturn("Call");
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/openai/gpt3/{id}", 1L)
                .param("objetivo", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("qtdSelecionada", String.valueOf(1));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link OpenAiController#gpt3(String, Integer, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGpt32() throws Exception {
        // Arrange
        when(receitaRepository.saveAll(Mockito.<Iterable<Receita>>any())).thenReturn(new ArrayList<>());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Receita receita = new Receita();
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        receita.setImage("Image");
        receita.setIngredientes(new String[]{"Ingredientes"});
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setQtdSelecionada(1);
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
        receita.setUsuario(usuario2);

        ArrayList<Receita> receitaList = new ArrayList<>();
        receitaList.add(receita);
        when(receitaService.desserializarListaReceitas(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(receitaList);
        when(openAiChatClient.call(Mockito.<String>any())).thenReturn("Call");
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/openai/gpt3/{id}", 1L)
                .param("objetivo", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("qtdSelecionada", String.valueOf(1));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<List><item><id>1</id><nome>Nome</nome><ingredientes><ingredientes>Ingredientes</ingredientes><"
                                + "/ingredientes><modoPreparo>Modo Preparo</modoPreparo><calorias>Calorias</calorias><tempoPreparo>Tempo"
                                + " Preparo</tempoPreparo><tipo>Tipo</tipo><proteina>Proteina</proteina><carboidratos>Carboidratos<"
                                + "/carboidratos><gorduras>Gorduras</gorduras><acucar>Acucar</acucar><dataCriacao>2024</dataCriacao>"
                                + "<dataCriacao>6</dataCriacao><dataCriacao>12</dataCriacao><qtdSelecionada>1</qtdSelecionada><image>Image"
                                + "</image><usuario><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><senha>Senha</senha>"
                                + "<img>Img</img><meta>Meta</meta><dataNascimento>0</dataNascimento><genero>Genero</genero><peso>10.0<"
                                + "/peso><altura>1</altura><nivelCondicao>Nivel Condicao</nivelCondicao><contaAtiva>true</contaAtiva>"
                                + "<pontuacao>1</pontuacao><horaSenhaAtualizacao>1970</horaSenhaAtualizacao><horaSenhaAtualizacao>1<"
                                + "/horaSenhaAtualizacao><horaSenhaAtualizacao>1</horaSenhaAtualizacao><horaSenhaAtualizacao>0<"
                                + "/horaSenhaAtualizacao><horaSenhaAtualizacao>0</horaSenhaAtualizacao><objetivo><id>1</id><objetivo"
                                + ">Objetivo</objetivo><usuario><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><senha>Senha"
                                + "</senha><img>Img</img><meta>Meta</meta><dataNascimento>0</dataNascimento><genero>Genero</genero><peso"
                                + ">10.0</peso><altura>1</altura><nivelCondicao>Nivel Condicao</nivelCondicao><contaAtiva>true</contaAtiva"
                                + "><pontuacao>1</pontuacao><horaSenhaAtualizacao>1970</horaSenhaAtualizacao><horaSenhaAtualizacao>1<"
                                + "/horaSenhaAtualizacao><horaSenhaAtualizacao>1</horaSenhaAtualizacao><horaSenhaAtualizacao>0<"
                                + "/horaSenhaAtualizacao><horaSenhaAtualizacao>0</horaSenhaAtualizacao><objetivo><id/><objetivo/><usuario"
                                + "/></objetivo></usuario></objetivo></usuario></item></List>"));
    }

    /**
     * Method under test: {@link OpenAiController#gpt3(String, Integer, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGpt33() throws Exception {
        // Arrange
        when(receitaRepository.saveAll(Mockito.<Iterable<Receita>>any())).thenReturn(new ArrayList<>());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Receita receita = new Receita();
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        receita.setImage("Image");
        receita.setIngredientes(new String[]{"Ingredientes"});
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setQtdSelecionada(1);
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
        receita.setUsuario(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(0);
        usuario3.setContaAtiva(false);
        usuario3.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("john.smith@example.org");
        usuario3.setGenero("42");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(2L);
        usuario3.setImg("42");
        usuario3.setMeta("42");
        usuario3.setNivelCondicao("42");
        usuario3.setNome("42");
        usuario3.setObjetivo(new Objetivo());
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(0);
        usuario3.setSenha("42");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(2L);
        objetivo2.setObjetivo("42");
        objetivo2.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(0);
        usuario4.setContaAtiva(false);
        usuario4.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("john.smith@example.org");
        usuario4.setGenero("42");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(2L);
        usuario4.setImg("42");
        usuario4.setMeta("42");
        usuario4.setNivelCondicao("42");
        usuario4.setNome("42");
        usuario4.setObjetivo(objetivo2);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(0);
        usuario4.setSenha("42");

        Receita receita2 = new Receita();
        receita2.setAcucar("42");
        receita2.setCalorias("42");
        receita2.setCarboidratos("42");
        receita2.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita2.setGorduras("42");
        receita2.setId(2L);
        receita2.setImage("42");
        receita2.setIngredientes(new String[]{"Ingredientes"});
        receita2.setModoPreparo("42");
        receita2.setNome("42");
        receita2.setProteina("42");
        receita2.setQtdSelecionada(0);
        receita2.setTempoPreparo("42");
        receita2.setTipo("42");
        receita2.setUsuario(usuario4);

        ArrayList<Receita> receitaList = new ArrayList<>();
        receitaList.add(receita2);
        receitaList.add(receita);
        when(receitaService.desserializarListaReceitas(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(receitaList);
        when(openAiChatClient.call(Mockito.<String>any())).thenReturn("Call");
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/openai/gpt3/{id}", 1L)
                .param("objetivo", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("qtdSelecionada", String.valueOf(1));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>2</id><nome>42</nome><ingredientes><ingredientes>Ingredientes</ingredientes></ingredientes"
                                        + "><modoPreparo>42</modoPreparo><calorias>42</calorias><tempoPreparo>42</tempoPreparo><tipo>42</tipo>"
                                        + "<proteina>42</proteina><carboidratos>42</carboidratos><gorduras>42</gorduras><acucar>42</acucar>"
                                        + "<dataCriacao>2024</dataCriacao><dataCriacao>6</dataCriacao><dataCriacao>12</dataCriacao><qtdSelecionada"
                                        + ">1</qtdSelecionada><image>42</image><usuario><id>2</id><nome>42</nome><email>john.smith@example.org<"
                                        + "/email><senha>42</senha><img>42</img><meta>42</meta><dataNascimento>0</dataNascimento><genero>42<"
                                        + "/genero><peso>0.5</peso><altura>0</altura><nivelCondicao>42</nivelCondicao><contaAtiva>false</contaAtiva"
                                        + "><pontuacao>0</pontuacao><horaSenhaAtualizacao>1970</horaSenhaAtualizacao><horaSenhaAtualizacao>1<"
                                        + "/horaSenhaAtualizacao><horaSenhaAtualizacao>1</horaSenhaAtualizacao><horaSenhaAtualizacao>0<"
                                        + "/horaSenhaAtualizacao><horaSenhaAtualizacao>0</horaSenhaAtualizacao><objetivo><id>2</id><objetivo>42"
                                        + "</objetivo><usuario><id>2</id><nome>42</nome><email>john.smith@example.org</email><senha>42</senha>"
                                        + "<img>42</img><meta>42</meta><dataNascimento>0</dataNascimento><genero>42</genero><peso>0.5</peso>"
                                        + "<altura>0</altura><nivelCondicao>42</nivelCondicao><contaAtiva>false</contaAtiva><pontuacao>0</pontuacao"
                                        + "><horaSenhaAtualizacao>1970</horaSenhaAtualizacao><horaSenhaAtualizacao>1</horaSenhaAtualizacao>"
                                        + "<horaSenhaAtualizacao>1</horaSenhaAtualizacao><horaSenhaAtualizacao>0</horaSenhaAtualizacao>"
                                        + "<horaSenhaAtualizacao>0</horaSenhaAtualizacao><objetivo><id/><objetivo/><usuario/></objetivo></usuario"
                                        + "></objetivo></usuario></item><item><id>1</id><nome>Nome</nome><ingredientes><ingredientes>Ingredientes"
                                        + "</ingredientes></ingredientes><modoPreparo>Modo Preparo</modoPreparo><calorias>Calorias</calorias>"
                                        + "<tempoPreparo>Tempo Preparo</tempoPreparo><tipo>Tipo</tipo><proteina>Proteina</proteina><carboidratos"
                                        + ">Carboidratos</carboidratos><gorduras>Gorduras</gorduras><acucar>Acucar</acucar><dataCriacao>2024<"
                                        + "/dataCriacao><dataCriacao>6</dataCriacao><dataCriacao>12</dataCriacao><qtdSelecionada>1</qtdSelecionada"
                                        + "><image>Image</image><usuario><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><senha"
                                        + ">Senha</senha><img>Img</img><meta>Meta</meta><dataNascimento>0</dataNascimento><genero>Genero</genero"
                                        + "><peso>10.0</peso><altura>1</altura><nivelCondicao>Nivel Condicao</nivelCondicao><contaAtiva>true<"
                                        + "/contaAtiva><pontuacao>1</pontuacao><horaSenhaAtualizacao>1970</horaSenhaAtualizacao><horaSenhaAtualizacao"
                                        + ">1</horaSenhaAtualizacao><horaSenhaAtualizacao>1</horaSenhaAtualizacao><horaSenhaAtualizacao>0<"
                                        + "/horaSenhaAtualizacao><horaSenhaAtualizacao>0</horaSenhaAtualizacao><objetivo><id>1</id><objetivo"
                                        + ">Objetivo</objetivo><usuario><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><senha>Senha"
                                        + "</senha><img>Img</img><meta>Meta</meta><dataNascimento>0</dataNascimento><genero>Genero</genero><peso"
                                        + ">10.0</peso><altura>1</altura><nivelCondicao>Nivel Condicao</nivelCondicao><contaAtiva>true</contaAtiva"
                                        + "><pontuacao>1</pontuacao><horaSenhaAtualizacao>1970</horaSenhaAtualizacao><horaSenhaAtualizacao>1<"
                                        + "/horaSenhaAtualizacao><horaSenhaAtualizacao>1</horaSenhaAtualizacao><horaSenhaAtualizacao>0<"
                                        + "/horaSenhaAtualizacao><horaSenhaAtualizacao>0</horaSenhaAtualizacao><objetivo><id/><objetivo/><usuario"
                                        + "/></objetivo></usuario></objetivo></usuario></item></List>"));
    }

    /**
     * Method under test:
     * {@link OpenAiController#receitaExtra(String, String, Long)}
     */
    @Test
    void testReceitaExtra() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Receita receita = new Receita();
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        receita.setImage("Image");
        receita.setIngredientes(new String[]{"Ingredientes"});
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setQtdSelecionada(1);
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
        receita.setUsuario(usuario2);
        when(receitaService.desserializarReceitaExtra(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(receita);
        when(openAiChatClient.call(Mockito.<String>any())).thenReturn("Call");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/openai/receita-extra/{id}", 1L)
                .param("acompanhamento", "foo")
                .param("principal", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(openAiController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<ReceitaResponseDTO><id>1</id><nome>Nome</nome><ingredientes><ingredientes>Ingredientes</ingredientes"
                                        + "></ingredientes><modoPreparo>Modo Preparo</modoPreparo><calorias>Calorias</calorias><tempoPreparo>Tempo"
                                        + " Preparo</tempoPreparo><tipo>Tipo</tipo><proteina>Proteina</proteina><carboidratos>Carboidratos<"
                                        + "/carboidratos><gorduras>Gorduras</gorduras><acucar>Acucar</acucar><qtdSelecionada>1</qtdSelecionada>"
                                        + "<image>Image</image></ReceitaResponseDTO>"));
    }
}
