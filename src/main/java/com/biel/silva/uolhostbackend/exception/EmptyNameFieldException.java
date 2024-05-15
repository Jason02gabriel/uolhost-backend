package com.biel.silva.uolhostbackend.exception;

public class EmptyNameFieldException extends RuntimeException {

    public EmptyNameFieldException(String msg){
        super(msg);
    }

    public EmptyNameFieldException(String msg, Throwable cause){
        super(msg, cause);
    }
}
