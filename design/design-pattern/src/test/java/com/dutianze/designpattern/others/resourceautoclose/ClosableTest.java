package com.dutianze.designpattern.others.resourceautoclose;

import com.dutianze.designpattern.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/8/28
 */
class ClosableTest {

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
    void openClose() {
        try (final SlidingDoor ignored = new SlidingDoor();
             final TreasureChest ignored1 = new TreasureChest()) {
            assertTrue(appender.logContains("Sliding door opens."));
            assertTrue(appender.logContains("Treasure chest opens."));
        }
        assertTrue(appender.logContains("Treasure chest closes."));
        assertTrue(appender.logContains("Sliding door closes."));
    }
}