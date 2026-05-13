package com.dws.recruitment_test.factory;

import com.dws.recruitment_test.config.CookieConfig;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import java.time.Duration;

@RequiredArgsConstructor
@Component
public class CookieFactory {

    private final CookieConfig config;

    public Cookie getCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);

        cookie.setDomain(config.getDomain());
        cookie.setHttpOnly(config.getHttpOnly());
        cookie.setSecure(config.getSecure());
        cookie.setPath(config.getPath());
        cookie.setMaxAge(value != null ? config.getMaxAge() : 0);

        return cookie;
    }

    public String getResponseCookie(String name, String value) {
        return ResponseCookie
                .from(name, value)
                .domain(config.getDomain())
                .httpOnly(config.getHttpOnly())
                .secure(config.getSecure())
                .maxAge(value != null ? config.getMaxAge() : 0)
                .build()
                .toString();
    }

    public String getResponseCookieWithMaxAge(String name, String value, Duration maxAge) {
        return ResponseCookie
                .from(name, this.clearCookie(value))
                .domain(config.getDomain())
                .httpOnly(config.getHttpOnly())
                .secure(config.getSecure())
                .maxAge(maxAge)
                .path("/")
                .sameSite("Lax")
                .build()
                .toString();
    }

    private String clearCookie(String cookie) {
        return cookie.split("=")[1];
    }
}
