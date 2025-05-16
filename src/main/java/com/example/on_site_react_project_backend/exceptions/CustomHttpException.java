package com.example.on_site_react_project_backend.exceptions;

import org.springframework.http.HttpStatus;

public abstract class CustomHttpException extends RuntimeException{
    private final HttpStatus status;
    private final String message;

    public CustomHttpException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
