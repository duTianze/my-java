package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author dutianze
 * @date 2024/3/12
 */
class N_229_MajorityElementIITest {

    private final N_229_MajorityElementII solution = new N_229_MajorityElementII();

    @Test
    void majorityElement() {
        int[] nums = {3, 2, 3};
        List<Integer> result = solution.majorityElement(nums);

        List<Integer> expectedNums = List.of(3);

        Assertions.assertEquals(expectedNums.size(), result.size());
        IntStream.range(0, expectedNums.size())
                 .forEach(i -> Assertions.assertEquals(expectedNums.get(i), result.get(i)));
    }
}