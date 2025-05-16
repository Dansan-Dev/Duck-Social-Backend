package com.example.on_site_react_project_backend.exception_related;

import org.springframework.stereotype.Component;

@Component
public class ExceptionUtils {
    public static String composeExceptionMessage(String reason, String method) {
        return String.format("Failed [%s]: %s", method, reason);
    }
}
