package com.dutianze.designpattern.others.eventdrivenarchitecture.framework;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.dutianze.designpattern.others.eventdrivenarchitecture.event.UserCreatedEvent;
import com.dutianze.designpattern.others.eventdrivenarchitecture.event.UserUpdatedEvent;
import com.dutianze.designpattern.others.eventdrivenarchitecture.handler.UserCreatedEventHandler;
import com.dutianze.designpattern.others.eventdrivenarchitecture.handler.UserUpdatedEventHandler;
import com.dutianze.designpattern.others.eventdrivenarchitecture.model.User;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/12
 */
class EventDispatcherTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      EventDispatcher dispatcher = new EventDispatcher();
      dispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
      dispatcher.registerHandler(UserUpdatedEvent.class, new UserUpdatedEventHandler());

      User user = new User("tom");
      dispatcher.dispatch(new UserCreatedEvent(user));
      dispatcher.dispatch(new UserUpdatedEvent(user));
    });
  }

  @Test
  void testEventDriverPattern() {
    EventDispatcher dispatcher = spy(new EventDispatcher());
    UserCreatedEventHandler userCreatedEventHandler = spy(new UserCreatedEventHandler());
    UserUpdatedEventHandler userUpdatedEventHandler = spy(new UserUpdatedEventHandler());
    dispatcher.registerHandler(UserCreatedEvent.class, userCreatedEventHandler);
    dispatcher.registerHandler(UserUpdatedEvent.class, userUpdatedEventHandler);

    User user = new User("tom");

    UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
    UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(user);

    //fire a userCreatedEvent and verify that userCreatedEventHandler has been invoked.
    dispatcher.dispatch(userCreatedEvent);
    verify(userCreatedEventHandler).onEvent(userCreatedEvent);
    verify(dispatcher).dispatch(userCreatedEvent);

    //fire a userCreatedEvent and verify that userUpdatedEventHandler has been invoked.
    dispatcher.dispatch(userUpdatedEvent);
    verify(userUpdatedEventHandler).onEvent(userUpdatedEvent);
    verify(dispatcher).dispatch(userUpdatedEvent);
  }
}