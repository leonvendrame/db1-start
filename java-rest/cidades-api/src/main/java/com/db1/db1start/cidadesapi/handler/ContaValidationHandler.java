package com.db1.db1start.cidadesapi.handler;

import com.db1.db1start.cidadesapi.exception.ContaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContaValidationHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ContaNotFoundException.class)
    public String handleContaNotFoundException(ContaNotFoundException exception) {
        return exception.getMessage();
    }
}
