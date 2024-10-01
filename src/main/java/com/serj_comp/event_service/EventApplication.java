package com.serj_comp.event_service;

import org.springframework.context.ApplicationEvent;

public class EventApplication extends ApplicationEvent {

    private EventBase event;

    public EventApplication(Object source, EventBase event) {
        super(source);
        this.event = event;

    }

    public EventBase getEvent() {
        return event;
    }
}
