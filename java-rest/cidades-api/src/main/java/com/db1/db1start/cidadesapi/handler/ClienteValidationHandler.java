package com.db1.db1start.cidadesapi.handler;

import com.db1.db1start.cidadesapi.exception.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClienteValidationHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public String handleClienteNotFoundException(ClienteNotFoundException exception) {
        return exception.getMessage();
    }
}
