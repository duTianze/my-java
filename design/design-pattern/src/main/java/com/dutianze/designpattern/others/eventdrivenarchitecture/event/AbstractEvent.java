package com.dutianze.designpattern.others.eventdrivenarchitecture.event;

import com.dutianze.designpattern.others.eventdrivenarchitecture.framework.Event;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public abstract class AbstractEvent implements Event {

  public Class<? extends Event> getType() {
    return getClass();
  }
}