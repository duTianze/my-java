package com.dutianze.designpattern.others.eventaggregator.emitter;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.enums.Weekday;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class Scout extends EventEmitter {

  public Scout() {
  }

  public Scout(EventObserver obs, Event e) {
    super(obs, e);
  }

  @Override
  public void timePasses(Weekday day) {
    if (day == Weekday.TUESDAY) {
      notifyObservers(Event.WARSHIPS_APPROACHING);
    }
    if (day == Weekday.WEDNESDAY) {
      notifyObservers(Event.WHITE_WALKERS_SIGHTED);
    }
  }
}
