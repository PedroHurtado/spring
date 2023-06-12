package com.example.demo.domain.pizza.exceptions;

import lombok.Getter;

@Getter
public class ExceptionPizza extends RuntimeException {
    private final int code;
    public ExceptionPizza(String message,int code){
        super(message);
        this.code = code;
    }
}
