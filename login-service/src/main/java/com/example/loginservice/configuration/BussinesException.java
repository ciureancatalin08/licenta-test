package com.example.loginservice.configuration;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class BussinesException extends RuntimeException {
    public BussinesException() {
        super();
    }

    public BussinesException(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinesException(String message) {
        super(message);
    }

    public BussinesException(Throwable cause) {
        super(cause);
    }
}