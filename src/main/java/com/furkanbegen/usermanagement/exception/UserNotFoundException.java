package com.furkanbegen.usermanagement.exception;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User Not Found");
    }
}
