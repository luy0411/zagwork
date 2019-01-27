package com.zagwork.test.user.microservice.core.exception;

public class ResourceNotFoundException extends RuntimeException {

    private Long id;
    private String type;
    private String message;

    public ResourceNotFoundException(Long id, String type) {
        this.id = id;
        this.type = type;
        this.message = String.format("%s with id %d not found.", type, id);
    }

    public ResourceNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
