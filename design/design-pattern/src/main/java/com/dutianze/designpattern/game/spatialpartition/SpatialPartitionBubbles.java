package com.dutianze.designpattern.game.spatialpartition;

import java.util.ArrayList;
import java.util.Map;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="http://gameprogrammingpatterns.com/spatial-partition.html">Game Programming Patterns/Spatial Partition</a> by Bob Nystrom</li>
 * <li><a href="https://www.youtube.com/watch?v=OJxEcs0w_kE">Quadtree tutorial</a> by Daniel Schiffman</li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/24
 */
public class SpatialPartitionBubbles extends SpatialPartitionGeneric<Bubble> {

    private final Map<Integer, Bubble> bubbles;
    private final QuadTree bubblesQuadTree;

    SpatialPartitionBubbles(Map<Integer, Bubble> bubbles, QuadTree bubblesQuadTree) {
        this.bubbles = bubbles;
        this.bubblesQuadTree = bubblesQuadTree;
    }

    void handleCollisionsUsingQt(Bubble b) {
        // finding points within area of a square drawn with centre same as
        // centre of bubble and length = radius of bubble
        var rect = new Rect(b.coordinateX, b.coordinateY, 2D * b.radius, 2D * b.radius);
        var quadTreeQueryResult = new ArrayList<Point<Bubble>>();
        this.bubblesQuadTree.query(rect, quadTreeQueryResult);
        //handling these collisions
        b.handleCollision(quadTreeQueryResult, this.bubbles);
    }
}
