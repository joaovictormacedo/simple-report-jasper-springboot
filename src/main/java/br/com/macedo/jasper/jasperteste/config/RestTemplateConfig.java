package br.com.macedo.jasper.jasperteste.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        RestTemplate restTemplate = builder.build();

        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();

        jacksonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_OCTET_STREAM));

        restTemplate.getMessageConverters().add(jacksonConverter);

        return restTemplate;

    }
}
