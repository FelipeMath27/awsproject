package com.cloudpragma.awsproject.infrastructure.exceptions;

public class CustomException extends RuntimeException{

    public CustomException (String message){
        super(message);
    }
}
