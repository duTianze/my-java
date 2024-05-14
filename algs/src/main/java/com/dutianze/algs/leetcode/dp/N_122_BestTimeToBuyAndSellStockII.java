package com.dutianze.algs.leetcode.dp;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/">122. Best Time to Buy and Sell Stock II</a>
 * <pre>
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 * </pre>
 *
 * @author dutianze
 * @date 2024/4/1
 */
public class N_122_BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }
}
