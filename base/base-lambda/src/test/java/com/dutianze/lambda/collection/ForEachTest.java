package com.dutianze.lambda.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * print element that length greater than 3
 *
 * @author dutianze
 * @date 2022/5/3
 */
class ForEachTest {

    private final ForEach forEach = new ForEach();

    @Test
    void forEach() {
        List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));

        forEach.forLoop(list);
        forEach.anonymous(list);
        forEach.lambda(list);
    }
}