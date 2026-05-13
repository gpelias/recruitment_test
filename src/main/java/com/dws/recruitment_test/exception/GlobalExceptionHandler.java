package com.dws.recruitment_test.exception;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignException(FeignException e) {
        return ResponseEntity
                .status(BAD_GATEWAY)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", BAD_GATEWAY.value(),
                        "error", "External API Integration Error",
                        "message", "The original bands API is currently unavailable or returned an error."
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception e) {
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "message", "An unexpected internal server error occurred."
                ));
    }

}