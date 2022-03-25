package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dutianze
 * @date 2022/3/25
 */
@SpringBootTest
class N_1512_NumberOfGoodPairsTest {

    @Autowired
    private N_1512_NumberOfGoodPairs solution;

    @Test
    void numIdenticalPairs() {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int result = solution.numIdenticalPairs(nums);
        Assertions.assertEquals(4, result);
    }

    @Test
    void numIdenticalPairsBetter() {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int result = solution.numIdenticalPairsBetter(nums);
        Assertions.assertEquals(4, result);
    }
}
