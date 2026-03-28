package com.hibernate.crud.exception;

public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
