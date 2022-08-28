package com.dutianze.designpattern.others.reactor;

import com.dutianze.designpattern.others.reactor.framework.SameThreadDispatcher;
import com.dutianze.designpattern.others.reactor.framework.ThreadPoolDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
class ReactorTest {

    /**
     * Test the application using pooled thread dispatcher.
     *
     * @throws IOException          if any I/O error occurs.
     * @throws InterruptedException if interrupted while stopping the application.
     */
    @Test
    void testAppUsingThreadPoolDispatcher() throws IOException, InterruptedException {
        log.info("testAppUsingThreadPoolDispatcher start");
        Server app = new Server(new ThreadPoolDispatcher(2));
        app.start();

        assertNotNull(app);

        Client client = new Client();
        client.start();

        assertNotNull(client);

        // allow clients to send requests. Artificial delay.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("sleep interrupted", e);
        }

        client.stop();

        app.stop();
        log.info("testAppUsingThreadPoolDispatcher stop");
    }

    /**
     * Test the application using same thread dispatcher.
     *
     * @throws IOException          if any I/O error occurs.
     * @throws InterruptedException if interrupted while stopping the application.
     */
    @Test
    void testAppUsingSameThreadDispatcher() throws IOException, InterruptedException {
        log.info("testAppUsingSameThreadDispatcher start");
        Server app = new Server(new SameThreadDispatcher());
        app.start();

        assertNotNull(app);

        Client client = new Client();
        client.start();

        assertNotNull(client);

        // allow clients to send requests. Artificial delay.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("sleep interrupted", e);
        }

        client.stop();

        app.stop();
        log.info("testAppUsingSameThreadDispatcher stop");
    }
}