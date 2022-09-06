package com.dutianze.designpattern.concurrency.lockableobject;

import com.dutianze.designpattern.concurrency.lockableobject.domain.Feind;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Creature;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Elf;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Human;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Orc;
import com.dutianze.designpattern.concurrency.lockableobject.domain.sword.SwordOfAragorn;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author dutianze
 * @date 2022/9/7
 */
@Slf4j
class LockableTest {

    private static final int WAIT_TIME = 3;
    private static final int WORKERS = 2;
    private static final int MULTIPLICATION_FACTOR = 3;

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            // The target object for this example.
            SwordOfAragorn sword = new SwordOfAragorn();
            // Creation of creatures.
            List<Creature> creatures = new ArrayList<>();
            for (int i = 0; i < WORKERS; i++) {
                creatures.add(new Elf(String.format("Elf %s", i)));
                creatures.add(new Orc(String.format("Orc %s", i)));
                creatures.add(new Human(String.format("Human %s", i)));
            }
            int totalFiends = WORKERS * MULTIPLICATION_FACTOR;
            ExecutorService service = Executors.newFixedThreadPool(totalFiends);
            // Attach every creature and the sword is a Fiend to fight for the sword.
            for (int i = 0; i < totalFiends; i = i + MULTIPLICATION_FACTOR) {
                service.submit(new Feind(creatures.get(i), sword));
                service.submit(new Feind(creatures.get(i + 1), sword));
                service.submit(new Feind(creatures.get(i + 2), sword));
            }
            // Wait for program to terminate.
            try {
                if (!service.awaitTermination(WAIT_TIME, TimeUnit.SECONDS)) {
                    log.info("The master of the sword is now {}.", sword.getLocker().getName());
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
                service.shutdown();
            }
        });
    }

}