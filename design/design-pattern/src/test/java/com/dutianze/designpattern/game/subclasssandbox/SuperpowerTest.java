package com.dutianze.designpattern.game.subclasssandbox;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.game.subclasssandbox.impl.GroundDive;
import com.dutianze.designpattern.game.subclasssandbox.impl.SkyLaunch;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/23
 */
@Slf4j
class SuperpowerTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      log.info("Use superpower: sky launch");
      Superpower skyLaunch = new SkyLaunch();
      skyLaunch.activate();

      log.info("Use superpower: ground dive");
      Superpower groundDive = new GroundDive();
      groundDive.activate();
    });
  }
}