package com.fcamara.desafio.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VehicleTypeException extends ResponseStatusException {
    public VehicleTypeException(){
        super(HttpStatus.BAD_REQUEST, "Type should be CAR or MOTORCYCLE");
    }
}
