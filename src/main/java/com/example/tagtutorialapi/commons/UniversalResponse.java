package com.example.tagtutorialapi.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UniversalResponse {
    private int status;
    private Object Data;
    private String message;
}
