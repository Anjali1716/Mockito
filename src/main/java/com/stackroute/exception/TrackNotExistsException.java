package com.stackroute.exception;

public class TrackNotExistsException extends Exception{

    private String message;

    public TrackNotExistsException(){}

    public TrackNotExistsException(String message){
        super(message);
        this.message=message;
    }
}




