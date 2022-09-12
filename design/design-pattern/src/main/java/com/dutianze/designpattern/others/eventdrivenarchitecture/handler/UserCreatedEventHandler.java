package com.dutianze.designpattern.others.eventdrivenarchitecture.handler;

import com.dutianze.designpattern.others.eventdrivenarchitecture.event.UserCreatedEvent;
import com.dutianze.designpattern.others.eventdrivenarchitecture.framework.Handler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@Slf4j
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

  @Override
  public void onEvent(UserCreatedEvent event) {
    log.info("User '{}' has been Created!", event.getUser().getUsername());
  }
}
