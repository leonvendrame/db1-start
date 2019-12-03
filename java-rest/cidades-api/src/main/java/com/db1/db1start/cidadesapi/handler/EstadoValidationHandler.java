package com.db1.db1start.cidadesapi.handler;

import com.db1.db1start.cidadesapi.exception.EstadoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EstadoValidationHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EstadoNotFoundException.class)
    public String handleEstadoNotFoundException(EstadoNotFoundException exception) {
        return exception.getMessage();
    }
}
