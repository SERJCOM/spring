package com.serj_comp.event_service;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface EventRepository extends CrudRepository<Event, Long> {

    ArrayList<Event> findAllByName(String name);

    @Query("SELECT e FROM Event e WHERE e.name = :name AND u.createdAt AFTER :fromDate")
    ArrayList<Event> findAllUsersByDate(@Param("name")String name, @Param("fromDate") Date fromDate);

    Event findByName(String name);

    Event findById(long id);

}
