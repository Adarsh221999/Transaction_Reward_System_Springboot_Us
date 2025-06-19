package com.transactionreward.Exception;

public class TransactionFailed extends  RuntimeException{
    public TransactionFailed(String message){
        super(message);
    }
}
