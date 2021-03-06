package com.erayt.analysis.listener;

import com.erayt.analysis.domain.User;
import com.erayt.analysis.event.OnRegistrationCompleteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Slf4j
@Component
public class EmailSendListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Override
    @NonNull
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        log.info("User register Email sender :" + user);
    }
}
