package com.chris.scoreapi.common.exceptions;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(){}

    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
