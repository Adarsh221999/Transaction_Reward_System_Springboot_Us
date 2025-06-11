package com.Transaction_Reward_System_Springboot_Us.Exception;

public class CustomerAlreadyExistByIdException extends RuntimeException{
    public CustomerAlreadyExistByIdException(String message ) {
        super(message);
    }
}
