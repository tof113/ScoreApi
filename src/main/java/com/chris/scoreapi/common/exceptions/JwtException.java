package com.chris.scoreapi.common.exceptions;

public class JwtException extends Exception{
    public JwtException(){}

    public JwtException(String message){
        super(message);
    }

    public JwtException(String message, Throwable cause){
        super(message, cause);
    }
}
