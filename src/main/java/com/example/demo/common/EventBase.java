package com.example.demo.common;

import java.util.Date;
import java.util.UUID;

import an.awesome.pipelinr.Notification;
import lombok.Getter;


@Getter
public class EventBase<T> implements Notification  {
    private final UUID id;
    private final Date date;
    private final String type;
    private final Object data;
    protected EventBase(UUID id, Date date, String type, T data) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.data = data;
    }    
}
