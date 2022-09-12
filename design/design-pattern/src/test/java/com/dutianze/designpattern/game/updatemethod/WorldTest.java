package com.dutianze.designpattern.game.updatemethod;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dutianze.designpattern.game.updatemethod.entity.Skeleton;
import com.dutianze.designpattern.game.updatemethod.entity.Statue;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/19
 */
class WorldTest {

  @Test
  void statueUpdateForPendingShoot() {
    Statue statue = new Statue(1, 20);
    statue.setFrames(10);

    statue.update();

    assertEquals(11, statue.getFrames());
  }

  @Test
  void statueUpdateForShooting() {
    Statue statue = new Statue(1, 20);
    statue.setFrames(19);

    statue.update();

    assertEquals(0, statue.getFrames());
  }

  @Test
  void statueUpdateForPatrollingLeft() {
    Skeleton skeleton = new Skeleton(1);
    skeleton.setPatrollingLeft(true);
    skeleton.setPosition(50);

    skeleton.update();

    assertEquals(49, skeleton.getPosition());
  }

  @Test
  void statueUpdateForPatrollingRight() {
    Skeleton skeleton = new Skeleton(1);
    skeleton.setPatrollingLeft(false);
    skeleton.setPosition(50);

    skeleton.update();

    assertEquals(51, skeleton.getPosition());
  }

  @Test
  void statueUpdateForReverseDirectionFromLeftToRight() {
    Skeleton skeleton = new Skeleton(1);
    skeleton.setPatrollingLeft(true);
    skeleton.setPosition(1);

    skeleton.update();

    assertEquals(0, skeleton.getPosition());
    assertFalse(skeleton.isPatrollingLeft());
  }

  @Test
  void worldTest() {
    assertDoesNotThrow(() -> {
      int GAME_RUNNING_TIME = 2000;
      World world = new World();
      world.run();
      assertTrue(world.isRunning);

      Skeleton skeleton1 = new Skeleton(1, 10);
      Skeleton skeleton2 = new Skeleton(2, 70);
      Statue statue = new Statue(3, 20);
      world.addEntity(skeleton1);
      world.addEntity(skeleton2);
      world.addEntity(statue);

      Thread.sleep(GAME_RUNNING_TIME);

      world.stop();
      assertFalse(world.isRunning);
    });
  }
}