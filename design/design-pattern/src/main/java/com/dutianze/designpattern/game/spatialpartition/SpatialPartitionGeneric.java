package com.dutianze.designpattern.game.spatialpartition;

import java.util.Hashtable;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public abstract class SpatialPartitionGeneric<T> {

    Hashtable<Integer, T> playerPositions;
    QuadTree quadTree;

    abstract void handleCollisionsUsingQt(T obj);
}
