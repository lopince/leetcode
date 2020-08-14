package com.leetcode.solution.dp;

public class BestTimeToBuyAndSellStock3 {

    private static class Solution {
        public int maxProfit(int[] prices) {
            int days = prices.length;

            int k = 2;

            // dp[j][0]: 当前日，最多进行j次交易的情况下，若股票卖出，此时最大利益
            // dp[j][1]: 当前日，最多进行j次交易的情况下，若买入股票，此时最大利益
            int[][] dp = new int[k + 1][2];

            // base case
            for (int i = 0; i <= k; i++) {
                // 第1日，交易尚未开始，获利为0
                dp[i][0] = 0;

                // 第1日，交易尚未开始，不可能持有股票
                dp[i][1] = Integer.MIN_VALUE;
            }

            // 0: rest after sell
            // 1: rest after buy
            for (int i = 1; i <= days; i++) {
                for (int j = 1; j <= k; j++) {

                    dp[j][0] = Math.max(
                            // rest
                            dp[j][0],

                            // sell
                            dp[j][1] + prices[i - 1]);

                    dp[j][1] = Math.max(
                            // rest
                            dp[j][1],

                            // buy
                            dp[j - 1][0] - prices[i - 1]);
                }
            }

            return dp[k][0];
        }
    }
}
