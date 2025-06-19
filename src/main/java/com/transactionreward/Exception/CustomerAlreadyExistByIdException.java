package com.transactionreward.Exception;

public class CustomerAlreadyExistByIdException extends RuntimeException{
    public CustomerAlreadyExistByIdException(String message ) {
        super(message);
    }
}
