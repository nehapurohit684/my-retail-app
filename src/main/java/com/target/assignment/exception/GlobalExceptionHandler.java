package com.target.assignment.exception;

import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException  exception, WebRequest request)
    {
        ErrorDetails err = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception  exception, WebRequest request)
    {
        ErrorDetails err = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
