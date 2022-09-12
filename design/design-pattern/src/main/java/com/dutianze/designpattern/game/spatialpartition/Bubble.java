package com.dutianze.designpattern.game.spatialpartition;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class Bubble extends Point<Bubble> {

  private static final SecureRandom RANDOM = new SecureRandom();

  final int radius;

  Bubble(int x, int y, int id, int radius) {
    super(x, y, id);
    this.radius = radius;
  }

  void move() {
    //moves by 1 unit in either direction
    this.coordinateX += RANDOM.nextInt(3) - 1;
    this.coordinateY += RANDOM.nextInt(3) - 1;
  }

  boolean touches(Bubble b) {
    //distance between them is greater than sum of radii (both sides of equation squared)
    return (this.coordinateX - b.coordinateX) * (this.coordinateX - b.coordinateX)
        + (this.coordinateY - b.coordinateY) * (this.coordinateY - b.coordinateY)
        <= (this.radius + b.radius) * (this.radius + b.radius);
  }

  void pop(Map<Integer, Bubble> allBubbles) {
    log.info("Bubble {} popped at ({},{})!", id, coordinateX, coordinateY);
    allBubbles.remove(this.id);
  }

  void handleCollision(Collection<? extends Point<Bubble>> toCheck,
      Map<Integer, Bubble> allBubbles) {
    boolean toBePopped = false;
    for (Point<Bubble> point : toCheck) {
      int otherId = point.id;
      if (allBubbles.get(otherId) != null &&
          this.id != otherId &&
          this.touches(allBubbles.get(otherId))) {
        allBubbles.get(otherId).pop(allBubbles);
        toBePopped = true;
      }
    }
    if (toBePopped) {
      this.pop(allBubbles);
    }
  }
}
