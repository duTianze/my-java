package com.dutainze.algs.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dutianze
 * @date 2022/3/27
 */
@SpringBootTest
class N_1431_KidsWithTheGreatestNumberOfCandiesTest {

    @Autowired
    private N_1431_KidsWithTheGreatestNumberOfCandies solution;

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
