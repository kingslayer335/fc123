package com.statsit.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiCfg {

    @Value("${faceitapi}")
    private String apiKey;
    
    public String getApiKey() {
        return apiKey;
    }
}
