package com.dutianze.designpattern.concurrency.lockableobject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.concurrency.lockableobject.domain.Feind;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Creature;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Elf;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Human;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Orc;
import com.dutianze.designpattern.concurrency.lockableobject.domain.sword.SwordOfAragorn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/7
 */
@Slf4j
class LockableTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      // The target object for this example.
      SwordOfAragorn sword = new SwordOfAragorn();
      // Creation of creatures.
      List<Creature> creatures = new ArrayList<>();

      creatures.add(new Elf(String.format("Elf %s", 0)));
      creatures.add(new Orc(String.format("Orc %s", 0)));
      creatures.add(new Human(String.format("Human %s", 0)));
      creatures.add(new Elf(String.format("Elf %s", 1)));
      creatures.add(new Orc(String.format("Orc %s", 1)));
      creatures.add(new Human(String.format("Human %s", 1)));

      ExecutorService service = Executors.newFixedThreadPool(6);
      // Attach every creature and the sword is a Fiend to fight for the sword.
      for (Creature creature : creatures) {
        service.submit(new Feind(creature, sword));
      }

      // Wait for program to terminate.
      try {
        if (!service.awaitTermination(3, TimeUnit.SECONDS)) {
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