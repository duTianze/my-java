package com.dutianze.lambda.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * remove element that length greater than 3
 *
 * @author dutianze
 * @date 2022/5/3
 */
class RemoveIfTest {

    private final RemoveIf removeIf = new RemoveIf();
    private List<String> list;
    private final List<String> expected = new ArrayList<>(Arrays.asList("I", "you", "too"));

    @BeforeEach
    void before() {
        list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
    }

    @Test
    void justFor() {
        Assertions.assertThrowsExactly(ConcurrentModificationException.class, () -> removeIf.justFor(list));
    }

    @Test
    void useIterator() {
        Assertions.assertEquals(expected, removeIf.useIterator(list));
    }

    @Test
    void anonymous() {
        Assertions.assertEquals(expected, removeIf.anonymous(list));
    }

    @Test
    void lambda() {
        Assertions.assertEquals(expected, removeIf.lambda(list));
    }
}