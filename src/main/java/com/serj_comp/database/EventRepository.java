package com.serj_comp.database;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.serj_comp.database.Event;


public interface EventRepository extends CrudRepository<Event, Long> {

    ArrayList<Event> findAllByName(String name);

    Event findByName(String name);

    Event findById(long id);

}
