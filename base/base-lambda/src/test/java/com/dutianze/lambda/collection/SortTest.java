package com.dutianze.lambda.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/4
 */
class SortTest {

    private final Sort sort = new Sort();
    private List<String> list;
    private final List<String> expected = new ArrayList<>(Arrays.asList("I", "you", "too", "love"));

    @BeforeEach
    void before() {
        list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
    }

    @Test
    void anonymous() {
        List<String> result = sort.anonymous(list);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void lambda() {
        List<String> result = sort.lambda(list);

        Assertions.assertEquals(expected, result);
    }
}