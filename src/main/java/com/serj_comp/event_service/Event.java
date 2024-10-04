package com.serj_comp.event_service;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

import jakarta.persistence.Entity;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String name;

    private String data;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Event(EventBase base) {
        this.data = base.data;
        this.name = base.name;
    }

    public Event(String name, String data) {
        this.data = data;
        this.name = name;
    }

    public Event(){}

}
