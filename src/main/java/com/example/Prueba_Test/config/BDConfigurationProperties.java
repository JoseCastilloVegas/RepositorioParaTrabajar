package com.example.Prueba_Test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource")
public record BDConfigurationProperties(String url, String username, String password) {
}
