package com.serj_comp.events;

import java.time.LocalDateTime;

public class EventBase {
    private String name;

    private LocalDateTime time;

    public EventBase(String name) {
        this.name = name;
    }

    public EventBase(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public EventBase getEvent() {
        return this;
    }

}