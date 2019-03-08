package com.kswr.wallets.api.walletsapi.exception;

public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException() {
        super("Such user does not exist");
    }

    public NoSuchUserException(Long id) {
        super("User with " + id + " does not exist");
    }

    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
