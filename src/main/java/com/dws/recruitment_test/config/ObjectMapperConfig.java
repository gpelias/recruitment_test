package com.dws.recruitment_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.deser.jdk.UUIDDeserializer;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static tools.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static tools.jackson.databind.SerializationFeature.INDENT_OUTPUT;

@Configuration
public class ObjectMapperConfig {

    @Bean
    @Primary
    public ObjectMapper jacksonJsonMapper() {
        return JsonMapper
                .builder()

                .addModule(this.uuidDeserializer())

                .defaultTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"))
                .defaultDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))

                .changeDefaultPropertyInclusion(incl -> incl.withValueInclusion(NON_NULL))

                .disable(INDENT_OUTPUT)
                .disable(FAIL_ON_EMPTY_BEANS)

                .build();
    }

    private SimpleModule uuidDeserializer() {
        SimpleModule module = new SimpleModule();

        module.addDeserializer(UUID.class, new UUIDDeserializer());

        return module;
    }
}