package com.kodilla.ecommercee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException exception) {
        return new ResponseEntity<>("Order with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalIdForOrderUpdateException.class)
    public ResponseEntity<Object> handleOrderAlreadyExistsException (IllegalIdForOrderUpdateException exception) {
        return new ResponseEntity<>("Illegal order id. Set id = 0 to create new order," +
                " or use PUT method to update existing order.", HttpStatus.BAD_REQUEST);
    }
}