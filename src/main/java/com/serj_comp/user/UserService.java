package com.serj_comp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.serj_comp.event_service.EventBase;
import com.serj_comp.event_service.EventPublisher;
import com.serj_comp.events.AuthFactory;
import com.serj_comp.service.InnerUserService;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    EventPublisher eventpublisher;

    public InnerUserService createUser(User user) {

        eventpublisher.createNewEvent(new AuthFactory().CreateAuthEvent(user.getName(), "228 1488 6996", true));

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
