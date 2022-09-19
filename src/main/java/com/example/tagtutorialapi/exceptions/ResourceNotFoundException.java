package com.example.tagtutorialapi.exceptions;

public class ResourceNotFoundException extends IllegalArgumentException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
}
