package com.zagwork.test.api.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class RestError {

    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    public RestError(HttpStatus status, String message, String path) {
        super();
        this.error = status.getReasonPhrase();
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public int getStatus() { return status.value(); }

    public String getError() { return error; }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @JsonIgnore
    public HttpStatus getHttpStatus() { return status; }

}
