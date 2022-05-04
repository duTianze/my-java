package com.dutianze.lambda.map;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * print all entry from map
 *
 * @author dutianze
 * @date 2022/5/4
 */
class ForEachTest {

    private final ForEach forEach = new ForEach();

    private final Map<Integer, String> map = Map.ofEntries(
            Map.entry(1, "one"),
            Map.entry(2, "two"),
            Map.entry(3, "three")
    );

    @Test
    void forLoop() {
        forEach.forLoop(map);
    }

    @Test
    void anonymous() {
        forEach.anonymous(map);
    }

    @Test
    void lambda() {
        forEach.lambda(map);
    }
}