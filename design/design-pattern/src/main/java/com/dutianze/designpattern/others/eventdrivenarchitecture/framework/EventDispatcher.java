package com.dutianze.designpattern.others.eventdrivenarchitecture.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class EventDispatcher {

  private final Map<Class<? extends Event>, Handler<? extends Event>> handlers;

  public EventDispatcher() {
    handlers = new HashMap<>();
  }

  public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
    handlers.put(eventType, handler);
  }

  @SuppressWarnings("unchecked")
  public <E extends Event> void dispatch(E event) {
    var handler = (Handler<E>) handlers.get(event.getClass());
    if (handler != null) {
      handler.onEvent(event);
    }
  }
}
