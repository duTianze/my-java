package com.dutianze.designpattern.others.eventaggregator.emitter;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.enums.Weekday;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class LordBaelish extends EventEmitter {

  public LordBaelish() {
  }

  public LordBaelish(EventObserver obs, Event e) {
    super(obs, e);
  }

  @Override
  public void timePasses(Weekday day) {
    if (day == Weekday.FRIDAY) {
      notifyObservers(Event.STARK_SIGHTED);
    }
  }
}
