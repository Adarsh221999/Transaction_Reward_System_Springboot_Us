package com.TransactionReward.Exception;

public class CustomerAlreadyExistByIdException extends RuntimeException{
    public CustomerAlreadyExistByIdException(String message ) {
        super(message);
    }
}
