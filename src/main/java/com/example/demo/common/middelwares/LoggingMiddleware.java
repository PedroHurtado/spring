package com.example.demo.common.middelwares;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
@Order(1)
public class LoggingMiddleware implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        System.out.println("log before");
        R response = next.invoke();
        System.out.println("log after");
        return response;
    }
} 
