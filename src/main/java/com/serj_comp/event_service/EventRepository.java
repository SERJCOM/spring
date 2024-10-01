package com.serj_comp.event_service;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, Long> {

    ArrayList<Event> findAllByName(String name);

    Event findByName(String name);

    Event findById(long id);

}
