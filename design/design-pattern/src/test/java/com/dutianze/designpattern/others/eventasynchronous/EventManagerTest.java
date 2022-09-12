package com.dutianze.designpattern.others.eventasynchronous;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dutianze.designpattern.others.eventasynchronous.exception.EventDoesNotExistException;
import com.dutianze.designpattern.others.eventasynchronous.exception.InvalidOperationException;
import com.dutianze.designpattern.others.eventasynchronous.exception.LongRunningEventException;
import com.dutianze.designpattern.others.eventasynchronous.exception.MaxNumOfEventsAllowedException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@Slf4j
class EventManagerTest {

  @Test
  void testAsynchronousEvent() {
    EventManager eventManager = new EventManager();
    try {
      int aEventId = eventManager.createAsync(60);
      eventManager.start(aEventId);

      assertEquals(1, eventManager.getEventPool().size());
      assertTrue(eventManager.getEventPool().size() < EventManager.MAX_RUNNING_EVENTS);
      assertEquals(-1, eventManager.numOfCurrentlyRunningSyncEvent());

      eventManager.cancel(aEventId);
      assertTrue(eventManager.getEventPool().isEmpty());
    } catch (MaxNumOfEventsAllowedException | LongRunningEventException |
             EventDoesNotExistException e) {
      log.error(e.getMessage());
    }
  }

  @Test
  void testSynchronousEvent() {
    EventManager eventManager = new EventManager();
    try {
      int sEventId = eventManager.create(60);
      eventManager.start(sEventId);

      assertEquals(1, eventManager.getEventPool().size());
      assertTrue(eventManager.getEventPool().size() < EventManager.MAX_RUNNING_EVENTS);
      assertNotEquals(-1, eventManager.numOfCurrentlyRunningSyncEvent());

      eventManager.cancel(sEventId);
      assertTrue(eventManager.getEventPool().isEmpty());
    } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException
             | InvalidOperationException e) {
      log.error(e.getMessage());
    }
  }
}