package com.serj_comp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.serj_comp.database.User;
import com.serj_comp.database.UserRepository;
import com.serj_comp.events.EventBase;
import com.serj_comp.events.EventPublisher;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    EventPublisher eventpublisher;

    public InnerUserService createUser(User user) {

        eventpublisher.createNewEvent(new EventBase(user.getName()));

        User _user = repo.findByName(user.getName());
        if (_user == null) {
            String hash = user.getName().concat(user.getPassword());
            hash = Hashing.sha256().hashString(hash, Charsets.UTF_8).toString();
            user.setToken(hash);
            repo.save(user);

            return new InnerUserService(hash);

        }

        return new InnerUserService(_user.getToken());
    }

    public String getEvents() {
        return events.toString();
    }

    private ArrayList<String> events;

    public UserService() {
        events = new ArrayList<String>();
    }
}
