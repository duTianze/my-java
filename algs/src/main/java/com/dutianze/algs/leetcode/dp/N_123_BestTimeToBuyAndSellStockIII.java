package com.dutianze.algs.leetcode.dp;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/">123. Best Time to Buy and Sell Stock III</a>
 * <pre>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 * </pre>
 *
 * @author dutianze
 * @date 2024/4/1
 */
public class N_123_BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
