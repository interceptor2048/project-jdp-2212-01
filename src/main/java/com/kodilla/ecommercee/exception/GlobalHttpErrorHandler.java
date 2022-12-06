package com.kodilla.ecommercee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Object> handleCartNotFoundException(CartNotFoundException exception) {
        return new ResponseEntity<>("Cart with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception) {
        return new ResponseEntity<>("Product with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>("User with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<Object> handleGroupNotFoundException(GroupNotFoundException exception) {
        return new ResponseEntity<>("Group with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException exception) {
        return new ResponseEntity<>("Order with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserWithGivenUserNameExist.class)
    public ResponseEntity<Object> handleUserWithGivenUserNameExist(UserWithGivenUserNameExist exception) {
        return new ResponseEntity<>("username is taken, choose another one", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoesntExist.class)
    public ResponseEntity<Object> handleUserDoesntExist(UserDoesntExist exception) {
        return new ResponseEntity<>("invalid login or password", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalIdForOrderCreateException.class)
    public ResponseEntity<Object> handleOrderAlreadyExistsException (IllegalIdForOrderCreateException exception) {
        return new ResponseEntity<>("Illegal order id. Set id = 0 to create new order," +
                " or use PUT method to update existing order.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CartItemDousntExist.class)
    public ResponseEntity<Object> handleCartItemDoesntExist (CartItemDousntExist exception) {
        return new ResponseEntity<>("You have no product to delete", HttpStatus.BAD_REQUEST);
    }
}
