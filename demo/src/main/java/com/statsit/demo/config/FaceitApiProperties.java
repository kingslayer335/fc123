package com.statsit.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "faceit.api")
public record FaceitApiProperties(
        String openBaseUrl,
        String statsBaseUrl,
        String apiKey
) {}