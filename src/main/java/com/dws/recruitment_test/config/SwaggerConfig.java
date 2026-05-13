package com.dws.recruitment_test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bands API - DWS Recruitment Test")
                        .version("1.0.0")
                        .description("REST API built for the DWS technical test, featuring caching, dynamic filtering, and sorting.")
                );
    }
}
