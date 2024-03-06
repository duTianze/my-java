package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/6
 */
class N_134_GasStationTest {

    private final N_134_GasStation solution = new N_134_GasStation();

    @Test
    void canCompleteCircuit() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int startIndex = solution.canCompleteCircuit(gas, cost);

        Assertions.assertEquals(3, startIndex);
    }
}