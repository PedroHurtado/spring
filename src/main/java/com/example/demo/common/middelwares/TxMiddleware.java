package com.example.demo.common.middelwares;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
@Order(0)
public class TxMiddleware implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        System.out.println("txt before");
        R response = next.invoke();
        System.out.println("txt after");
        return response;
    }
}
