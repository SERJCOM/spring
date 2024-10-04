package com.serj_comp.event_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.Date;

@Component
public class EventService implements ApplicationListener<EventApplication> {
    @Autowired
    EventRepository eventRepo;

    @Override
    public void onApplicationEvent(EventApplication event){
        eventRepo.save(new Event(event.getEvent()));
        // System.out.println("new event");
    }

    public ArrayList<Event> getEvents(String name){
        return eventRepo.findAllByName(name);
    }

    public ArrayList<Event> getEventsFromDate(String name, Date startFrom){
        return eventRepo.findAllUsersByDate(name, startFrom);
    }
}
