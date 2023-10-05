package com.pessoal.esebo.utils.handler;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private HttpStatus statusCode;
    private String message;

    public CustomException(HttpStatus statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
