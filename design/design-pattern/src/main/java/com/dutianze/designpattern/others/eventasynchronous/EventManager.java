package com.dutianze.designpattern.others.eventasynchronous;

import com.dutianze.designpattern.others.eventasynchronous.exception.EventDoesNotExistException;
import com.dutianze.designpattern.others.eventasynchronous.exception.InvalidOperationException;
import com.dutianze.designpattern.others.eventasynchronous.exception.LongRunningEventException;
import com.dutianze.designpattern.others.eventasynchronous.exception.MaxNumOfEventsAllowedException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class EventManager implements ThreadCompleteListener {

  public static final int MAX_RUNNING_EVENTS = 1000;
  // Just don't want to have too many running events. :)
  public static final int MIN_ID = 1;
  public static final int MAX_ID = MAX_RUNNING_EVENTS;
  public static final int MAX_EVENT_TIME = 1800; // in seconds / 30 minutes.
  private int currentlyRunningSyncEvent = -1;
  private final SecureRandom rand;
  private final Map<Integer, Event> eventPool;

  private static final String DOES_NOT_EXIST = " does not exist.";

  public EventManager() {
    rand = new SecureRandom();
    eventPool = new ConcurrentHashMap<>(MAX_RUNNING_EVENTS);
  }

  /**
   * Create a Synchronous event
   */
  public int create(int eventTime)
      throws MaxNumOfEventsAllowedException, InvalidOperationException, LongRunningEventException {
    if (currentlyRunningSyncEvent != -1) {
      throw new InvalidOperationException("Event [" + currentlyRunningSyncEvent +
          "] is still running. Please wait until it finishes and try again.");
    }

    int eventId = createEvent(eventTime, true);
    currentlyRunningSyncEvent = eventId;
    return eventId;
  }

  /**
   * Create an Asynchronous event
   */
  public int createAsync(int eventTime)
      throws MaxNumOfEventsAllowedException, LongRunningEventException {
    return createEvent(eventTime, false);
  }

  private int createEvent(int eventTime, boolean isSynchronous)
      throws MaxNumOfEventsAllowedException, LongRunningEventException {
    if (eventPool.size() == MAX_RUNNING_EVENTS) {
      throw new MaxNumOfEventsAllowedException("Too many events are running at the moment."
          + " Please try again later.");
    }
    if (eventTime >= MAX_EVENT_TIME) {
      throw new LongRunningEventException(
          "Maximum event time allowed is " + MAX_EVENT_TIME + " seconds. Please try again.");
    }

    int newEventId = generateId();
    Event newEvent = new Event(newEventId, eventTime, isSynchronous);
    newEvent.addListener(this);
    eventPool.put(newEventId, newEvent);
    return newEventId;
  }

  public void start(int eventId) throws EventDoesNotExistException {
    if (!eventPool.containsKey(eventId)) {
      throw new EventDoesNotExistException(eventId + DOES_NOT_EXIST);
    }

    eventPool.get(eventId).start();
  }

  public void cancel(int eventId) throws EventDoesNotExistException {
    if (!eventPool.containsKey(eventId)) {
      throw new EventDoesNotExistException(eventId + DOES_NOT_EXIST);
    }
    if (eventId == currentlyRunningSyncEvent) {
      currentlyRunningSyncEvent = -1;
    }

    eventPool.get(eventId).stop();
    eventPool.remove(eventId);
  }

  public void status(int eventId) throws EventDoesNotExistException {
    if (!eventPool.containsKey(eventId)) {
      throw new EventDoesNotExistException(eventId + DOES_NOT_EXIST);
    }

    eventPool.get(eventId).status();
  }

  @SuppressWarnings("rawtypes")
  public void shutdown() {
    eventPool.entrySet().forEach(entry -> ((Event) ((Map.Entry) entry).getValue()).stop());
  }

  private int generateId() {
    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
    while (eventPool.containsKey(randomNum)) {
      randomNum = rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
    }
    return randomNum;
  }

  @Override
  public void completedEventHandler(int eventId) {
    eventPool.get(eventId).status();
    if (eventPool.get(eventId).isSynchronous()) {
      currentlyRunningSyncEvent = -1;
    }
    eventPool.remove(eventId);
  }

  public Map<Integer, Event> getEventPool() {
    return eventPool;
  }

  public int numOfCurrentlyRunningSyncEvent() {
    return currentlyRunningSyncEvent;
  }
}
