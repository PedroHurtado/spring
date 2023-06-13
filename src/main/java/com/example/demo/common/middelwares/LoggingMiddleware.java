package com.example.demo.common.middelwares;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
@Order(1)
public class LoggingMiddleware implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        // log command
        R response = next.invoke();
        // log response
        return response;
    }
} 
