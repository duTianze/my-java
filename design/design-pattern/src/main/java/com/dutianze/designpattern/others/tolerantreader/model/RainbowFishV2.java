package com.dutianze.designpattern.others.tolerantreader.model;

import com.dutianze.designpattern.others.tolerantreader.model.RainbowFish;
import lombok.Getter;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/8/21
 */
@Getter
public class RainbowFishV2 extends RainbowFish {

    @Serial
    private static final long serialVersionUID = 1L;

    private boolean sleeping;
    private boolean hungry;
    private boolean angry;

    public RainbowFishV2(String name, int age, int lengthMeters, int weightTons) {
        super(name, age, lengthMeters, weightTons);
    }

    public RainbowFishV2(String name, int age, int lengthMeters, int weightTons, boolean sleeping,
                         boolean hungry, boolean angry) {
        this(name, age, lengthMeters, weightTons);
        this.sleeping = sleeping;
        this.hungry = hungry;
        this.angry = angry;
    }
}
