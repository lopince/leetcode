package com.leetcode.question.dp;

public class BestTimeToBuyAndSellStock {

    private static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            // 前i天的最大收益
            int[] dp = new int[n + 1];

            // base case
            dp[0] = 0;

            // dp
            int minPrice = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], prices[i - 1] - minPrice);
                minPrice = Math.min(minPrice, prices[i - 1]);
            }

            return dp[n];
        }
    }
}
