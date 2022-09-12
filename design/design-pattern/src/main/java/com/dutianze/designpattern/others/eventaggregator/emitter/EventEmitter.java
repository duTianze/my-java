package com.dutianze.designpattern.others.eventaggregator.emitter;

import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.enums.Weekday;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public abstract class EventEmitter {

  private final Map<Event, List<EventObserver>> observerLists;

  public EventEmitter() {
    observerLists = new HashMap<>();
  }

  public EventEmitter(EventObserver obs, Event e) {
    this();
    registerObserver(obs, e);
  }

  public final void registerObserver(EventObserver obs, Event e) {
    if (!observerLists.containsKey(e)) {
      observerLists.put(e, new LinkedList<>());
    }
    if (!observerLists.get(e).contains(obs)) {
      observerLists.get(e).add(obs);
    }
  }

  protected void notifyObservers(Event e) {
    if (observerLists.containsKey(e)) {
      observerLists.get(e).forEach(observer -> observer.onEvent(e));
    }
  }

  public abstract void timePasses(Weekday day);
}
