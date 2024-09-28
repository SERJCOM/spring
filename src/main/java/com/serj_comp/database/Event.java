package com.serj_comp.database;

import com.serj_comp.events.EventBase;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Event  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Event(EventBase base){
        super();
        this.setName(base.getName());
        this.setTime(base.getTime());
    }

    public Event(){}


    private String name;

    private LocalDateTime time;



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

}
