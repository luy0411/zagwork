package com.zagwork.test.risk.microservice.service.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> noHandlerFound(NoHandlerFoundException exception, HttpServletRequest request) {
        RestError restError = new RestError(HttpStatus.NOT_FOUND, exception.getMessage(),  request.getServletPath());
        return new ResponseEntity<>(restError, new HttpHeaders(), restError.getHttpStatus());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> noMethodFound(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        RestError restError = new RestError(HttpStatus.METHOD_NOT_ALLOWED, exception.getMessage(), request.getServletPath());
        return new ResponseEntity<>(restError, new HttpHeaders(), restError.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> invalidArgument(MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
        RestError restError = new RestError(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getServletPath());
        return new ResponseEntity<>(restError, new HttpHeaders(), restError.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception exception, HttpServletRequest request) {
        RestError restError = new RestError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), request.getServletPath());
        return new ResponseEntity<>(restError, new HttpHeaders(), restError.getHttpStatus());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> repositoryError(HttpClientErrorException exception, HttpServletRequest request) {
        RestError restError = new RestError(HttpStatus.BAD_REQUEST, exception.getResponseBodyAsString(), request.getServletPath());
        return new ResponseEntity<>(restError, new HttpHeaders(), restError.getHttpStatus());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Object> repositoryError(HttpServerErrorException exception, HttpServletRequest request) {
        RestError restError = new RestError(HttpStatus.BAD_REQUEST, exception.getResponseBodyAsString(), request.getServletPath());
        return new ResponseEntity<>(restError, new HttpHeaders(), restError.getHttpStatus());
    }
}
