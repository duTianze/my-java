package com.dutianze.designpattern.others.twin;

import com.dutianze.designpattern.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.stream.IntStream;

import static java.lang.Thread.sleep;
import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/20
 */
class BallItemTest {

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
        assertDoesNotThrow(() -> {
            BallItem ballItem = new BallItem();
            BallThread ballThread = new BallThread();

            ballItem.setTwin(ballThread);
            ballThread.setTwin(ballItem);

            ballThread.start();

            Thread.sleep(750);
            ballItem.click();

            Thread.sleep(750);
            ballItem.click();

            Thread.sleep(750);
            ballThread.stopMe();
        });
    }

    @Test
    void clickSwitchIsSuspend() {
        final BallItem ballItem = new BallItem();

        final BallThread ballThread = mock(BallThread.class);
        ballItem.setTwin(ballThread);

        final InOrder inOrder = inOrder(ballThread);

        IntStream.range(0, 10).forEach(i -> {
            ballItem.click();
            inOrder.verify(ballThread).suspendMe();
            ballItem.click();
            inOrder.verify(ballThread).resumeMe();
        });

        inOrder.verifyNoMoreInteractions();
    }

    @Test
    void drawInvokeDoDraw() {
        final BallItem ballItem = new BallItem();

        final BallThread ballThread = mock(BallThread.class);
        ballItem.setTwin(ballThread);

        ballItem.draw();
        assertTrue(appender.logContains("draw"));
        assertTrue(appender.logContains("doDraw"));

        verifyNoMoreInteractions(ballThread);
        assertEquals(2, appender.getLogSize());
    }

    @Test
    void move() {
        final BallItem ballItem = new BallItem();

        final BallThread ballThread = mock(BallThread.class);
        ballItem.setTwin(ballThread);

        ballItem.move();
        assertTrue(appender.logContains("move"));

        verifyNoMoreInteractions(ballThread);
        assertEquals(1, appender.getLogSize());
    }

    @Test
    void suspend() {
        assertTimeout(ofMillis(5000), () -> {
            final BallThread ballThread = new BallThread();

            final BallItem ballItem = mock(BallItem.class);
            ballThread.setTwin(ballItem);

            ballThread.start();
            sleep(200);
            verify(ballItem, atLeastOnce()).draw();
            verify(ballItem, atLeastOnce()).move();
            ballThread.suspendMe();

            sleep(1000);

            ballThread.stopMe();
            ballThread.join();

            verifyNoMoreInteractions(ballItem);
        });
    }

    @Test
    void resume() {
        assertTimeout(ofMillis(5000), () -> {
            final BallThread ballThread = new BallThread();

            final BallItem ballItem = mock(BallItem.class);
            ballThread.setTwin(ballItem);

            ballThread.suspendMe();
            ballThread.start();

            sleep(1000);

            verifyNoMoreInteractions(ballItem);

            ballThread.resumeMe();
            sleep(300);
            verify(ballItem, atLeastOnce()).draw();
            verify(ballItem, atLeastOnce()).move();

            ballThread.stopMe();
            ballThread.join();

            verifyNoMoreInteractions(ballItem);
        });
    }

    @Test
    void interrupt() {
        assertTimeout(ofMillis(5000), () -> {
            final BallThread ballThread = new BallThread();
            final Thread.UncaughtExceptionHandler exceptionHandler = mock(Thread.UncaughtExceptionHandler.class);
            ballThread.setUncaughtExceptionHandler(exceptionHandler);
            ballThread.setTwin(mock(BallItem.class));
            ballThread.start();
            ballThread.interrupt();
            ballThread.join();

            verify(exceptionHandler).uncaughtException(eq(ballThread), any(RuntimeException.class));
            verifyNoMoreInteractions(exceptionHandler);
        });
    }
}