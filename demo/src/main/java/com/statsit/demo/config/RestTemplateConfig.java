package com.statsit.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {
    private final FaceitApiProperties properties;

    @Bean(name = "faceitAuth")
    public RestTemplate faceitAuthRestTemplate(RestTemplateBuilder builder) {
        return builder
                .additionalInterceptors((request, body, execution) -> {
                    request.getHeaders()
                            .setBearerAuth(properties.apiKey());
                    return execution.execute(request, body);
                })
                .build();
    }

    @Bean(name = "faceitNoAuth")
    public RestTemplate faceitNoAuthRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}