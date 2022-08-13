package com.dutianze.designpattern.structural.adapter.boat;

/**
 * @author dutianze
 * @date 2022/8/11
 */
public class FishingBoatAdapter implements RowingBoat {

    private final FishingBoat boat = new FishingBoat();

    @Override
    public void row() {
        boat.sail();
    }
}
