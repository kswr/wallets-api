package com.kswr.wallets.api.walletsapi.exception;

import org.springframework.security.core.AuthenticationException;

public class UserIdNotFoundException extends AuthenticationException {
    public UserIdNotFoundException() {
        super("Such user does not exist");
    }

    public UserIdNotFoundException(Long id) {
        super("User with " + id + " does not exist");
    }

    public UserIdNotFoundException(String message) {
        super(message);
    }

    public UserIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
