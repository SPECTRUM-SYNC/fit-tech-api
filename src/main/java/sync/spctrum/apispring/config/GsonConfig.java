package sync.spctrum.apispring.config;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfig {

    @Bean
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Converters.registerAll(gsonBuilder);
        return gsonBuilder.create();
    }
}
