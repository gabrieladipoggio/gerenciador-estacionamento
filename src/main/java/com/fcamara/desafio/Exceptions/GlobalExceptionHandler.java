package com.fcamara.desafio.Exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VehicleNotRegisteredException.class)
    public ResponseEntity<Object> handleVehicleNotRegisteredException(
            VehicleNotRegisteredException exception,
            WebRequest request
    ){
        // Adicionar lógica para lidar com as exceções
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(VehicleTypeException.class)
    public ResponseEntity<String> handleVehicleTypeException(
            VehicleTypeException exception,
            WebRequest request
    ){

        // Adicionar lógica para lidar com as exceções
        return new ResponseEntity<String>(exception.getReason(), HttpStatus.BAD_REQUEST);
    }
}
