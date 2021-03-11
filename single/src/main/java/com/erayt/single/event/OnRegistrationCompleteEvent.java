package com.erayt.single.event;

import com.erayt.single.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 *
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {


    private final User user;


    public OnRegistrationCompleteEvent(final User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}