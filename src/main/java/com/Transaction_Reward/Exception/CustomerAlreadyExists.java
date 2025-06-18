package com.Transaction_Reward.Exception;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String message) {
        super(message);
    }
}
