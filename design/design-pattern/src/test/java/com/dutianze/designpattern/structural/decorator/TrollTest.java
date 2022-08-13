package com.dutianze.designpattern.structural.decorator;

import com.dutianze.designpattern.structural.decorator.troll.ClubbedTroll;
import com.dutianze.designpattern.structural.decorator.troll.SimpleTroll;
import com.dutianze.designpattern.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * @author dutianze
 * @date 2022/8/13
 */
class TrollTest {

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
    void testTrollActions() {
        final Troll troll = new SimpleTroll();
        assertEquals(10, troll.getAttackPower());

        troll.attack();
        assertEquals("The troll tries to grab you!", appender.getLastMessage());

        troll.fleeBattle();
        assertEquals("The troll shrieks in horror and runs away!", appender.getLastMessage());

        assertEquals(2, appender.getLogSize());
    }

    @Test
    void testClubbedTroll() {
        // Create a normal troll first, but make sure we can spy on it later on.
        final Troll simpleTroll = spy(new SimpleTroll());

        // Now we want to decorate the troll to make it stronger ...
        final Troll clubbed = new ClubbedTroll(simpleTroll);
        assertEquals(20, clubbed.getAttackPower());
        verify(simpleTroll, times(1)).getAttackPower();

        // Check if the clubbed troll actions are delegated to the decorated troll
        clubbed.attack();
        verify(simpleTroll, times(1)).attack();

        clubbed.fleeBattle();
        verify(simpleTroll, times(1)).fleeBattle();
        verifyNoMoreInteractions(simpleTroll);
    }
}