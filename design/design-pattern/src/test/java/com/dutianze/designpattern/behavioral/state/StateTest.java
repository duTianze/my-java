package com.dutianze.designpattern.behavioral.state;

import com.dutianze.designpattern.behavioral.state.context.Mammoth;
import com.dutianze.designpattern.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class StateTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    @Test
    void usage() {
        final Mammoth mammoth = new Mammoth();

        mammoth.observe();
        assertEquals("The mammoth is calm and peaceful.", appender.getLastMessage());
        assertEquals(1, appender.getLogSize());

        mammoth.timePasses();
        assertEquals("The mammoth gets angry!", appender.getLastMessage());
        assertEquals(2, appender.getLogSize());

        mammoth.observe();
        assertEquals("The mammoth is furious!", appender.getLastMessage());
        assertEquals(3, appender.getLogSize());

        mammoth.timePasses();
        assertEquals("The mammoth calms down.", appender.getLastMessage());
        assertEquals(4, appender.getLogSize());

        mammoth.observe();
        assertEquals("The mammoth is calm and peaceful.", appender.getLastMessage());
        assertEquals(5, appender.getLogSize());

    }
}