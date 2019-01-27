package com.zagwork.test.api.exception;

public class MicroserviceIntegrationException extends RuntimeException {

    public MicroserviceIntegrationException() {
    }

    public MicroserviceIntegrationException(String message) {
        super(message);
    }

    public MicroserviceIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MicroserviceIntegrationException(Throwable cause) {
        super(cause);
    }

    public MicroserviceIntegrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
