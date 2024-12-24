package com.example.shvlog.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public abstract class VlogException extends RuntimeException {

    public final Map<String, String> validation = new HashMap<>();

    public VlogException(String message) {
        super(message);
    }

    public VlogException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }
}

