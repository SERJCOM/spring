package com.serj_comp.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class EventPublisher {
    @Autowired
    ApplicationEventPublisher publisher;

    public void createNewEvent(EventBase event){
        EventApplication eventapl = new EventApplication(this, event);
        publisher.publishEvent(eventapl);
    }
}
