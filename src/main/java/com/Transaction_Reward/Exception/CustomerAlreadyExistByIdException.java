package com.Transaction_Reward.Exception;

public class CustomerAlreadyExistByIdException extends RuntimeException{
    public CustomerAlreadyExistByIdException(String message ) {
        super(message);
    }
}
