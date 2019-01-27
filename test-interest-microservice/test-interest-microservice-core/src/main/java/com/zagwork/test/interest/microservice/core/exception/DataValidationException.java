package com.zagwork.test.interest.microservice.core.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class DataValidationException extends RuntimeException {

    private final List<FieldError> errors;
    private final String type;

    public DataValidationException(String type, List<FieldError> errors) {
        this.type = type;
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        if(errors.size() == 1) return String.format("%s validation error. There is 1 error.", type);
        return String.format("%s validation error. There are %d errors.", type, errors.size());
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}
