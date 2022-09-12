package com.dutianze.designpattern.others.eventdrivenarchitecture.handler;

import com.dutianze.designpattern.others.eventdrivenarchitecture.event.UserUpdatedEvent;
import com.dutianze.designpattern.others.eventdrivenarchitecture.framework.Handler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@Slf4j
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {

  @Override
  public void onEvent(UserUpdatedEvent event) {
    log.info("User '{}' has been Updated!", event.getUser().getUsername());
  }
}
