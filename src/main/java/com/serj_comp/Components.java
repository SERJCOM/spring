package com.serj_comp;

import com.serj_comp.event_service.Event;
import com.serj_comp.event_service.EventService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serj_comp.service.InnerUserService;
import com.serj_comp.user.User;
import com.serj_comp.user.UserService;

import java.text.DateFormat;

@RestController
public class Components {

	@Autowired
	UserService userservice;

	@Autowired
	EventService eventservice;

	@GetMapping("/auth")
	public InnerUserService auth(@RequestParam(value = "user") String user,
			@RequestParam(value = "password") String password) {

		return userservice.createUser(new User(user, password));
	}

	@GetMapping("/event_date")
	public String getEventsByDate(@RequestParam(value = "name") String name, @RequestParam(value = "time") Long time) {

		ArrayList<Event> events;
		try {
			events = eventservice.getEventsFromDate(name, new Date(2024, 9, 1));
			return events.get(0).getData();
		} catch (Exception e) {
			System.out.println("Error: String getEvents: ".concat(e.getMessage()));
		}

		return null;

	}


	@GetMapping("/event")
	public String getEvents(@RequestParam(value = "name") String name) {

		ArrayList<Event> events;
		try {
			events = eventservice.getEvents(name);
			return events.get(0).getData();
		} catch (Exception e) {
			System.out.println("Error: String getEvents: ".concat(e.getMessage()));
		}

		return null;

	}
}