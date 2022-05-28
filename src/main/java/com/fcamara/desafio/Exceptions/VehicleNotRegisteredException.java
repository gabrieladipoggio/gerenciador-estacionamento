package com.fcamara.desafio.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VehicleNotRegisteredException extends ResponseStatusException {
    public VehicleNotRegisteredException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }

}

