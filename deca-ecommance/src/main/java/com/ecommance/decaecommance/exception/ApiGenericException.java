package com.ecommance.decaecommance.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiGenericException extends RuntimeException {

    private String errorStatusCode;
    private String errorMessage;
    private final LocalDateTime errorTime = LocalDateTime.now();

    public ApiGenericException(String message, String errorStatusCode, String errorMessage) {
        super(message);
        this.errorStatusCode = errorStatusCode;
        this.errorMessage = errorMessage;
    }
}