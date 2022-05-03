package com.dutianze.lambda.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/3
 */
class RemoveIfTest {

    private final RemoveIf removeIf = new RemoveIf();

    @Test
    void useIterator() {
        List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));

        Assertions.assertThrowsExactly(ConcurrentModificationException.class, () -> removeIf.justFor(list));
        removeIf.useIterator(list);
        removeIf.anonymous(list);
        removeIf.lambda(list);
    }
}