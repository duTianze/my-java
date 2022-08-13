package com.dutianze.designpattern.structural.facade;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.dutianze.designpattern.structural.facade.impl.DwarvenGoldmineFacadeImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/8/13
 */
class DwarvenGoldmineFacadeTest {

    private InMemoryAppender appender;

    @BeforeEach
    void setUp() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    void tearDown() {
        appender.stop();
    }

    @Test
    void testFullWorkDay() {
        final DwarvenGoldmineFacade goldMine = new DwarvenGoldmineFacadeImpl();
        goldMine.startNewDay();

        // On the start of a day, all workers should wake up ...
        assertTrue(appender.logContains("Dwarf gold digger wakes up."));
        assertTrue(appender.logContains("Dwarf cart operator wakes up."));
        assertTrue(appender.logContains("Dwarven tunnel digger wakes up."));

        // ... and go to the mine
        assertTrue(appender.logContains("Dwarf gold digger goes to the mine."));
        assertTrue(appender.logContains("Dwarf cart operator goes to the mine."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes to the mine."));

        // No other actions were invoked, so the workers shouldn't have done (printed) anything else
        assertEquals(6, appender.getLogSize());

        // Now do some actual work, start digging gold!
        goldMine.digOutGold();

        // Since we gave the dig command, every worker should be doing it's job ...
        assertTrue(appender.logContains("Dwarf gold digger digs for gold."));
        assertTrue(appender.logContains("Dwarf cart operator moves gold chunks out of the mine."));
        assertTrue(appender.logContains("Dwarven tunnel digger creates another promising tunnel."));

        // Again, they shouldn't be doing anything else.
        assertEquals(9, appender.getLogSize());

        // Enough gold, lets end the day.
        goldMine.endDay();

        // Check if the workers go home ...
        assertTrue(appender.logContains("Dwarf gold digger goes home."));
        assertTrue(appender.logContains("Dwarf cart operator goes home."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes home."));

        // ... and go to sleep. We need well rested workers the next day :)
        assertTrue(appender.logContains("Dwarf gold digger goes to sleep."));
        assertTrue(appender.logContains("Dwarf cart operator goes to sleep."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes to sleep."));

        // Every worker should be sleeping now, no other actions allowed
        assertEquals(15, appender.getLogSize());
    }

    private static class InMemoryAppender extends AppenderBase<ILoggingEvent> {

        private final List<ILoggingEvent> log = new LinkedList<>();

        public InMemoryAppender() {
            ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
            start();
        }

        @Override
        protected void append(ILoggingEvent eventObject) {
            log.add(eventObject);
        }

        public int getLogSize() {
            return log.size();
        }

        public boolean logContains(String message) {
            return log.stream()
                      .map(ILoggingEvent::getFormattedMessage)
                      .anyMatch(message::equals);
        }
    }
}