package com.Transaction_Reward.Exception;

public class TransactionFailed extends  RuntimeException{
    public TransactionFailed(String message){
        super(message);
    }
}
