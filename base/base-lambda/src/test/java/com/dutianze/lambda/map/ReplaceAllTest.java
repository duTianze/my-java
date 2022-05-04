package com.dutianze.lambda.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/5/4
 */
class ReplaceAllTest {

    private Map<Integer, String> map;
    private final ReplaceAll replaceAll = new ReplaceAll();

    private final Map<Integer, String> expected = new HashMap<>() {{
        put(1, "ONE");
        put(2, "TWO");
        put(3, "THREE");
    }};

    @BeforeEach
    void before() {
        map = new HashMap<>() {{
            put(1, "one");
            put(2, "two");
            put(3, "three");
        }};
    }

    @AfterEach
    void after() {
        Assertions.assertEquals(expected, map);
    }

    @Test
    void forLoop() {
        replaceAll.forLoop(map);
    }

    @Test
    void anonymous() {
        replaceAll.anonymous(map);
    }

    @Test
    void lambda() {
        replaceAll.lambda(map);
    }
}