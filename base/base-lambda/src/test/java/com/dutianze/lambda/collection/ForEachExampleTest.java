package com.dutianze.lambda.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/3
 */
class ForEachExampleTest {

    private final ForEachExample forEachExample = new ForEachExample();

    @Test
    void justFor() {
        List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));

        forEachExample.justFor(list);
        forEachExample.anonymous(list);
        forEachExample.lambda(list);
    }
}