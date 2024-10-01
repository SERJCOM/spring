package com.serj_comp.event_service;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EventBase {
    protected String name;

    protected LocalDateTime time;

    protected String data;

    protected String typeevent;



}