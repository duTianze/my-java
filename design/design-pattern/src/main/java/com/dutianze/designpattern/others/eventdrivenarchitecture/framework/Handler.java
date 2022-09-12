package com.dutianze.designpattern.others.eventdrivenarchitecture.framework;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public interface Handler<E extends Event> {

  void onEvent(E event);
}
