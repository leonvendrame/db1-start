package com.db1.db1start.cidadesapi.handler;

import com.db1.db1start.cidadesapi.exception.AgenciaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AgenciaValidationHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(AgenciaNotFoundException.class)
    public String handleAgenciaNotFoundException(AgenciaNotFoundException exception) {
        return exception.getMessage();
    }
}
