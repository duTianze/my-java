package com.dutianze.lambda.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * replace element that length greater than 3 to upper case
 *
 * @author dutianze
 * @date 2022/5/3
 */
class ReplaceAllTest {

    private final ReplaceAll replaceAll = new ReplaceAll();
    private List<String> list;
    private final List<String> expected = new ArrayList<>(Arrays.asList("I", "LOVE", "you", "too"));

    @BeforeEach
    void before() {
        list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
    }

    @Test
    void forLoop() {
        Assertions.assertEquals(expected, replaceAll.forLoop(list));
    }

    @Test
    void anonymous() {
        Assertions.assertEquals(expected, replaceAll.anonymous(list));

    }

    @Test
    void lambda() {
        Assertions.assertEquals(expected, replaceAll.lambda(list));
    }
}