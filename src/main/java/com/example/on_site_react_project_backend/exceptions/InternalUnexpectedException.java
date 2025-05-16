package com.example.on_site_react_project_backend.exceptions;

import org.springframework.http.HttpStatus;

public class InternalUnexpectedException extends CustomHttpException {
    public InternalUnexpectedException(HttpStatus status, String message) {
        super(status, message);
    }
}
