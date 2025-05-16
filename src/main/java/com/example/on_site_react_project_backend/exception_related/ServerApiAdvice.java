package com.example.on_site_react_project_backend.exception_related;

import com.example.custom_server_spring_api.exceptions.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ServerApiAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleException(UserNotFoundException exception, WebRequest request) {
        return handleExceptionInternal(
                exception,
                exception.getMessage(),
                new HttpHeaders(),
                exception.getStatus(),
                request
        );
    }
}
