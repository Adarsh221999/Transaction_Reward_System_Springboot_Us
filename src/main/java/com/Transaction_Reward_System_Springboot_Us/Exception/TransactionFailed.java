package com.Transaction_Reward_System_Springboot_Us.Exception;

public class TransactionFailed extends  RuntimeException{
    public TransactionFailed(String message){
        super(message);
    }
}
