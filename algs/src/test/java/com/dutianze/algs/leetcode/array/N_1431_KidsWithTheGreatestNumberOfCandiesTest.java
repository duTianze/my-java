package com.dutianze.algs.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dutianze
 * @date 2022/3/27
 */
class N_1431_KidsWithTheGreatestNumberOfCandiesTest {

    private final N_1431_KidsWithTheGreatestNumberOfCandies solution =
            new N_1431_KidsWithTheGreatestNumberOfCandies();

    @Test
    void kidsWithCandies() {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        Boolean[] expectedArray = {true, true, true, false, true};
        List<Boolean> expected = Arrays.stream(expectedArray).collect(Collectors.toList());

        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
