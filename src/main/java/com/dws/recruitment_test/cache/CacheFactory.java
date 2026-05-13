package com.dws.recruitment_test.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheFactory {

    @Bean
    public Cache<String, String> cacheManager() {
        return Caffeine
                .newBuilder()
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build();
    }

}
