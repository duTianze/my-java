package com.dutianze.designpattern.others.tolerantreader;

import com.dutianze.designpattern.others.tolerantreader.model.RainbowFish;
import com.dutianze.designpattern.others.tolerantreader.model.RainbowFishV2;

import java.io.*;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/21
 */
public final class RainbowFishSerializer {

    public static final String LENGTH_METERS = "lengthMeters";
    public static final String WEIGHT_TONS = "weightTons";

    private RainbowFishSerializer() {
    }

    public static void writeV1(RainbowFish rainbowFish, String filename) throws IOException {
        Map<String, String> map = Map.of(
                "name", rainbowFish.getName(),
                "age", String.format("%d", rainbowFish.getAge()),
                LENGTH_METERS, String.format("%d", rainbowFish.getLengthMeters()),
                WEIGHT_TONS, String.format("%d", rainbowFish.getWeightTons())
        );

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(map);
        }
    }

    public static void writeV2(RainbowFishV2 rainbowFish, String filename) throws IOException {
        Map<String, String> map = Map.of(
                "name", rainbowFish.getName(),
                "age", String.format("%d", rainbowFish.getAge()),
                LENGTH_METERS, String.format("%d", rainbowFish.getLengthMeters()),
                WEIGHT_TONS, String.format("%d", rainbowFish.getWeightTons()),
                "angry", Boolean.toString(rainbowFish.isAngry()),
                "hungry", Boolean.toString(rainbowFish.isHungry()),
                "sleeping", Boolean.toString(rainbowFish.isSleeping())
        );

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(map);
        }
    }

    @SuppressWarnings("unchecked")
    public static RainbowFish readV1(String filename) throws IOException, ClassNotFoundException {
        Map<String, String> map;

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            map = (Map<String, String>) objIn.readObject();
        }

        return new RainbowFish(
                map.get("name"),
                Integer.parseInt(map.get("age")),
                Integer.parseInt(map.get(LENGTH_METERS)),
                Integer.parseInt(map.get(WEIGHT_TONS))
        );
    }
}
