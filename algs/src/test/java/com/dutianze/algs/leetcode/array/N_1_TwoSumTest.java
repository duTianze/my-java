package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dutianze
 * @date 2022/5/7
 */
class N_1_TwoSumTest {

    private final N_1_TwoSum solution = new N_1_TwoSum();

    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};

        int[] result = solution.twoSum(nums, target);

        Set<Integer> expectedSet = Arrays.stream(expected).boxed().collect(Collectors.toSet());
        Set<Integer> resultSet = Arrays.stream(result).boxed().collect(Collectors.toSet());
        Assertions.assertEquals(expectedSet, resultSet);
    }
}