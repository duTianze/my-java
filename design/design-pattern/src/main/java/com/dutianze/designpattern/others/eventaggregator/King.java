package com.dutianze.designpattern.others.eventaggregator;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.emitter.EventObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@Slf4j
public class King implements EventObserver {

  @Override
  public void onEvent(Event e) {
    log.info("Received event from the King's Hand: {}", e.toString());
  }
}
