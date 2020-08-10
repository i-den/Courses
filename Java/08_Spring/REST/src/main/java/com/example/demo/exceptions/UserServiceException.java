package com.example.demo.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = -7981295503972332149L;

    public UserServiceException(String message) {
        super(message);
    }
}
