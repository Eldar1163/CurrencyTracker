package com.example.currencytracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {ConstraintViolationException.class, EmptyStringException.class})
    public ResponseEntity<AppError> badRequestHandler(RuntimeException exception) {
        return ResponseEntity.badRequest().body(new AppError(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(value = {InternalError.class})
    public ResponseEntity<AppError> internalErrorHandler(RuntimeException exception) {
        return ResponseEntity.internalServerError().body(new AppError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()));
    }
}
