package com.dws.recruitment_test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "cookie")
public class CookieConfig {

    private String domain;

    private Boolean httpOnly;

    private Boolean secure;

    private String path;

    private Integer maxAge;

}
