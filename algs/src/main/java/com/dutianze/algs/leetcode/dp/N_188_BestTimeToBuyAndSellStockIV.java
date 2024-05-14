package com.dutianze.algs.leetcode.dp;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/">188. Best Time to Buy and Sell Stock IV</a>
 * <pre>
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Constraints:
 *
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * </pre>
 *
 * @author dutianze
 * @date 2024/5/13
 */
public class N_188_BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {maxPro += prices[i] - prices[i - 1];}
            }
            return maxPro;
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][k][0];
    }

    public int maxProfitInfinite(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfitInfiniteOptimize(int[] prices) {
        int n = prices.length;
        int preHave = -prices[0];
        int preNot = 0;
        for (int i = 1; i < n; i++) {
            int tmpPreNot = preNot;
            preNot = Math.max(preNot, preHave + prices[i]);
            preHave = Math.max(preHave, tmpPreNot - prices[i]);
        }
        return preNot;
    }
}
