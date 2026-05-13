package com.dws.recruitment_test.factory;

import com.dws.recruitment_test.config.CorsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

@RequiredArgsConstructor
@Component
public class CorsFactory {

    private final CorsConfig corsConfig;

    public CorsConfiguration getCorsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(corsConfig.getAllowedOrigins());
        config.setAllowedMethods(corsConfig.getAllowedMethods());
        config.setAllowedHeaders(corsConfig.getAllowedHeaders());
        config.setAllowCredentials(corsConfig.getAllowCredentials());

        return config;
    }

}
