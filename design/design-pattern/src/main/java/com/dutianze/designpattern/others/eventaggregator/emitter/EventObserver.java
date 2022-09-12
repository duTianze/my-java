package com.dutianze.designpattern.others.eventaggregator.emitter;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public interface EventObserver {

  void onEvent(Event e);
}
