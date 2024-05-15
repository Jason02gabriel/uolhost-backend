package com.biel.silva.uolhostbackend.exception;

public class EmptyEmailFieldException extends RuntimeException {

    public EmptyEmailFieldException(String msg){
        super(msg);
    }

    public EmptyEmailFieldException(String msg, Throwable cause){
        super(msg, cause);
    }
}
