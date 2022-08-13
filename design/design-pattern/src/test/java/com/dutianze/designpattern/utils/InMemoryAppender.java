package com.dutianze.designpattern.utils;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class InMemoryAppender extends AppenderBase<ILoggingEvent> {

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

    public String getLastMessage() {
        return log.get(log.size() - 1).getFormattedMessage();
    }
}
