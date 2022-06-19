package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/19
 */
class N_752_OpenTheLockTest {

    private final N_752_OpenTheLock solution = new N_752_OpenTheLock();

    @Test
    void openLock() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};

        int result = solution.openLock(deadends, "0202");

        Assertions.assertEquals(6, result);
    }
}