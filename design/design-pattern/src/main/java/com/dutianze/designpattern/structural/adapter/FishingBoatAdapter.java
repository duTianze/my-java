package com.dutianze.designpattern.structural.adapter;

/**
 * @author dutianze
 * @date 2022/8/11
 */
public class FishingBoatAdapter implements RowingBoat {

    private final FishingBoat boat = new FishingBoat();

    public final void row() {
        boat.sail();
    }
}
