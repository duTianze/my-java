package com.dutianze.designpattern.others.eventdrivenarchitecture.framework;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public interface Event {

  Class<? extends Event> getType();
}
