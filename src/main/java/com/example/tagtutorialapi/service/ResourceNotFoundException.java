package com.example.tagtutorialapi.service;

public class ResourceNotFoundException extends IllegalArgumentException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
}
