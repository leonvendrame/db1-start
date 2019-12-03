package com.db1.db1start.cidadesapi.handler;

import com.db1.db1start.cidadesapi.exception.CidadeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CidadeValidationHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(CidadeNotFoundException.class)
    public String handleCidadeNotFoundException(CidadeNotFoundException exception) {
        return exception.getMessage();
    }
}
