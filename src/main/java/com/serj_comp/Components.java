package com.serj_comp;

// import com.serj_comp.events;
import com.serj_comp.database.User;
import com.serj_comp.events.EventService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serj_comp.service.InnerUserService;
import com.serj_comp.service.UserService;

import com.serj_comp.database.Event;


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

	@GetMapping("/event")
	public String getEvents(@RequestParam(value = "name") String name) {
		String string = "";
		ArrayList<Event> events = eventservice.getEvents(name);
		for(int i = 0; i < events.size(); i++){
			string = string.concat(" ").concat(events.get(i).getName());
		}

		return string;
	}
}