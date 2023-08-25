package de.schulung.Schulung.rest.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    public String handleNoSuchElementException(NoSuchElementException ex) {
        return ex.getMessage() + "... vllt hilft Geld?";
    }
}
