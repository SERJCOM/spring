package com.serj_comp.events;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serj_comp.event_service.EventBase;

import lombok.Data;

@Data
class Auth_ {
    private String type_event;
    private Boolean success;
    private String sid;
}

class AuthEvent extends EventBase {
    public void CreateAuthEvent(String token, Boolean success) {
        Auth_ auth = new Auth_();
        auth.setSid(token);
        auth.setType_event("auth");
        auth.setSuccess(success);

        try {
            this.data = new ObjectMapper().writeValueAsString(auth);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class AuthFactory {

    public EventBase CreateAuthEvent(String name, String token, Boolean success) {
        AuthEvent event = new AuthEvent();
        event.setName(name);
        event.setCreatedAt(new Date());
        event.CreateAuthEvent(token, success);
        return event;

    }

}
