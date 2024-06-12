package sync.spctrum.apispring.service.dallE;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sync.spctrum.apispring.service.dallE.dto.ImageRequest;
import sync.spctrum.apispring.service.dallE.dto.ImageResponse;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class ImageGenerator {

    private final RestTemplate restTemplate;
    private static final String OPENAI_URL = "https://api.openai.com/v1/images/generations";

    public String generateImage(ImageRequest imageRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<ImageRequest> entity = new HttpEntity<>(imageRequest, headers);

        ResponseEntity<ImageResponse> response = restTemplate.exchange(OPENAI_URL, HttpMethod.POST, entity, ImageResponse.class);

        ImageResponse imageResponse = response.getBody();
        if (imageResponse != null && !imageResponse.getData().isEmpty()) {
            return imageResponse.getData().get(0).get("url");
        } else {
            return null;
        }
    }
}
