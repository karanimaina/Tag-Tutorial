package com.example.tagtutorialapi.commons;

import lombok.Data;

@Data
public class UniversalResponse {
    private int status;
    private Object Data;
    private String message;
}
