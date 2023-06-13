package com.example.demo.common;

import java.util.ArrayList;
import java.util.List;

import an.awesome.pipelinr.Notification;

public class AgregateRoot {
    private final List<Notification> events = new ArrayList<>();
    public void add(Notification eventBase){
        events.add(eventBase);
    }
    public void remove(Notification eventBase){
        events.remove(eventBase);
    }
    public List<Notification> getEvents(){
        return events.stream().toList();
    }
    public void clear(){
        events.clear();
    }
}
