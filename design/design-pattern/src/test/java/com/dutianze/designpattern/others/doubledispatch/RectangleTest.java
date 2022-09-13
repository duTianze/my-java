package com.dutianze.designpattern.others.doubledispatch;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.doubledispatch.entity.Entity;
import com.dutianze.designpattern.others.doubledispatch.entity.monster.GreenSlime;
import com.dutianze.designpattern.others.doubledispatch.entity.monster.Monster;
import com.dutianze.designpattern.others.doubledispatch.entity.player.Fighter;
import com.dutianze.designpattern.others.doubledispatch.entity.player.Player;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/14
 */
@Slf4j
class RectangleTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      // initialize game objects and print their status
      List<Entity> objects = List.of(
          new Monster(0, 0, 5, 5),
          new GreenSlime(1, 1, 2, 2),
          new Fighter(10, 10, 15, 15),
          new Player(12, 12, 14, 14)
      );
      objects.forEach(o -> log.info(o.toString()));
      log.info("");

      // collision check
      objects.forEach(o1 -> objects.forEach(o2 -> {
        if (o1 != o2 && o1.intersectsWith(o2)) {
          o1.collision(o2);
        }
      }));
      log.info("");

      // output eventual object statuses
      objects.forEach(o -> log.info(o.toString()));
      log.info("");
    });
  }

}