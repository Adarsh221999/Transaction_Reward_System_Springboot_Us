package com.TransactionReward.Exception;

public class TransactionFailed extends  RuntimeException{
    public TransactionFailed(String message){
        super(message);
    }
}
