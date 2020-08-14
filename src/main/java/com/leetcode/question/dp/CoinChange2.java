package com.leetcode.question.dp;

public class CoinChange2 {

    private static class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;

            // dp[j], 凑某额度j，最多的组合数
            int[] dp = new int[amount + 1];

            // base
            for (int i = 0; i <= n; i++) {
                // 额度为0, 不放硬币
                dp[0] = 1;
            }

            // 遍历每种硬币
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++) {



                    // 如果当前硬币可以使用
                    if (j - coins[i - 1] >= 0) {
                        dp[j] =
                                // 不使用硬币i
                                dp[j]
                                        // 使用硬币i
                                        + dp[j - coins[i - 1]];

                    }
                }
            }

            return dp[amount];
        }
    }
}
