package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/6/5
 */
class N_309_BestTimeToBuyAndSellStockWithCooldownTest {

    private final N_309_BestTimeToBuyAndSellStockWithCooldown solution =
            new N_309_BestTimeToBuyAndSellStockWithCooldown();

    /**
     * Example 1:
     * Input: prices = [1,2,3,0,2]
     * Output: 3
     * Explanation: transactions = [buy, sell, cooldown, buy, sell]
     *
     * <p>
     * Example 2:
     * Input: prices = [1]
     * Output: 0
     */
    @Test
    void maxProfit() {
        int maxProfit = solution.maxProfit(new int[]{1, 2, 3, 0, 2});
        Assertions.assertEquals(3, maxProfit);
    }
}