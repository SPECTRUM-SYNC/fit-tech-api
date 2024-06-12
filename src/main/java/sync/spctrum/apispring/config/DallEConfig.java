package sync.spctrum.apispring.config;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class DallEConfig {

    @Value("${dallE.api.key}")
    private String openaiApiKey;

    @Bean
    public RestTemplate getImage() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                Collections.singletonList(getOpenAIKeyInterceptor())
        );
        return restTemplate;
    }

    private ClientHttpRequestInterceptor getOpenAIKeyInterceptor() {
        return (request, body, execution) -> {
            if (StringUtils.isBlank(openaiApiKey)) {
                throw new RuntimeException("Chave de API OpenAI não configurada.");
            }
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey.trim());
            return execution.execute(request, body);
        };
    }

}