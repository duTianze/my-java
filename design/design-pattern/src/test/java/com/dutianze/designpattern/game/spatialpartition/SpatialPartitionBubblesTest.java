package com.dutianze.designpattern.game.spatialpartition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author dutianze
 * @date 2022/8/25
 */
@Slf4j
class SpatialPartitionBubblesTest {

    private static final String BUBBLE = "Bubble ";

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            Map<Integer, Bubble> bubbles1 = new ConcurrentHashMap<>();
            Map<Integer, Bubble> bubbles2 = new ConcurrentHashMap<>();
            SecureRandom rand = new SecureRandom();
            for (int i = 0; i < 10000; i++) {
                Bubble b = new Bubble(rand.nextInt(300), rand.nextInt(300), i, rand.nextInt(2) + 1);
                bubbles1.put(i, b);
                bubbles2.put(i, b);
                log.info(BUBBLE + "{} with radius {} added at ({},{})", i, b.radius, b.coordinateX, b.coordinateY);
            }

            long start1 = System.currentTimeMillis();
            noSpatialPartition(20, bubbles1);
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            withSpatialPartition(300, 300, 20, bubbles2);
            long end2 = System.currentTimeMillis();

            log.info("Without spatial partition takes {} ms", (end1 - start1));
            log.info("With spatial partition takes {} ms", (end2 - start2));
        });
    }

    void noSpatialPartition(int numOfMovements, Map<Integer, Bubble> bubbles) {
        //all bubbles have to be checked for collision for all bubbles
        Collection<Bubble> bubblesToCheck = bubbles.values();

        //will run numOfMovement times or till all bubbles have popped
        while (numOfMovements > 0 && !bubbles.isEmpty()) {
            bubbles.forEach((i, bubble) -> {
                // bubble moves, new position gets updated
                // and collisions are checked with all bubbles in bubblesToCheck
                bubble.move();
                bubbles.replace(i, bubble);
                bubble.handleCollision(bubblesToCheck, bubbles);
            });
            numOfMovements--;
        }
        //bubbles not popped
        bubbles.keySet().stream().map(key -> BUBBLE + key + " not popped").forEach(log::info);
    }

    void withSpatialPartition(int height, int width, int numOfMovements, Map<Integer, Bubble> bubbles) {
        //creating quadtree
        Rect rect = new Rect(width / 2D, height / 2D, width, height);
        QuadTree quadTree = new QuadTree(rect, 4);

        //will run numOfMovement times or till all bubbles have popped
        while (numOfMovements > 0 && !bubbles.isEmpty()) {
            //quadtree updated each time
            bubbles.values().forEach(quadTree::insert);
            bubbles.forEach((i, bubble) -> {
                //bubble moves, new position gets updated, quadtree used to reduce computations
                bubble.move();
                bubbles.replace(i, bubble);
                SpatialPartitionBubbles sp = new SpatialPartitionBubbles(bubbles, quadTree);
                sp.handleCollisionsUsingQt(bubble);
            });
            numOfMovements--;
        }
        //bubbles not popped
        bubbles.keySet().stream().map(key -> BUBBLE + key + " not popped").forEach(log::info);
    }
}