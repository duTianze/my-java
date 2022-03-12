package com.dutainze.algs.array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/3/12
 */
class N_1920_BuildArrayFromPermutationTest {

    private N_1920_BuildArrayFromPermutation solution = new N_1920_BuildArrayFromPermutation();

    @Test
    void buildArrayTest() {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] expected = {0, 1, 2, 4, 5, 3};

        int[] actual = solution.buildArray(nums);

        Assertions.assertArrayEquals(actual, expected);
    }
}
