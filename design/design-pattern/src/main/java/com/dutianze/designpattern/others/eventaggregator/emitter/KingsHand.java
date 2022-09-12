package com.dutianze.designpattern.others.eventaggregator.emitter;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.enums.Weekday;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class KingsHand extends EventEmitter implements EventObserver {

  public KingsHand() {
  }

  public KingsHand(EventObserver obs, Event e) {
    super(obs, e);
  }

  @Override
  public void onEvent(Event e) {
    notifyObservers(e);
  }

  @Override
  public void timePasses(Weekday day) {
  }
}
