package com.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InstantAppExceptions.InvalidCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidCredentials(InstantAppExceptions.InvalidCredentialsException ex) {
        return new ResponseEntity<>(new ExceptionResponse("Unauthorized", ex.getMessage(), 401), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InstantAppExceptions.UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFound(InstantAppExceptions.UserNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionResponse("User Not Found", ex.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InstantAppExceptions.BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequest(InstantAppExceptions.BadRequestException ex) {
        return new ResponseEntity<>(new ExceptionResponse("Bad Request", ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneric(Exception ex) {
        return new ResponseEntity<>(new ExceptionResponse("Internal Error", ex.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
