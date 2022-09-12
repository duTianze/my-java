package com.dutianze.designpattern.others.eventaggregator.emitter;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.enums.Weekday;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@Slf4j
public class LordVarys extends EventEmitter implements EventObserver {

  public LordVarys() {
  }

  public LordVarys(EventObserver obs, Event e) {
    super(obs, e);
  }

  @Override
  public void timePasses(Weekday day) {
    if (day == Weekday.SATURDAY) {
      notifyObservers(Event.TRAITOR_DETECTED);
    }
  }

  @Override
  public void onEvent(Event e) {
    notifyObservers(e);
  }
}
