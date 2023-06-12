package com.example.demo.common;

import java.util.ArrayList;
import java.util.List;

public class AgregateRoot {
    private final List<EventBase> events = new ArrayList<>();
    public void add(EventBase eventBase){
        events.add(eventBase);
    }
    public void remove(EventBase eventBase){
        events.remove(eventBase);
    }
    public List<EventBase> getEvents(){
        return events.stream().toList();
    }
    public void clear(){
        events.clear();
    }
}
