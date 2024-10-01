package com.serj_comp;

import com.serj_comp.event_service.Event;
import com.serj_comp.event_service.EventService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serj_comp.service.InnerUserService;
import com.serj_comp.user.User;
import com.serj_comp.user.UserService;


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
		// String string = "";
		ArrayList<Event> events = eventservice.getEvents(name);
		return events.get(0).getData();
		// for(int i = 0; i < events.size(); i++){
		// 	string = string.concat(" ").concat(events.get(i).getData());
		// }

		// return string;
	}
}