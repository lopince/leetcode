package com.leetcode.solution.dp;

public class Fib {

    private static class Solution {

        private int fib(int N) {

            if (N == 0) {
                return 0;
            }

            if (N == 1 || N == 2) {
                return 1;
            }

            // now n>2
            int[] dp = new int[N + 1];

            // base case;
            dp[0] = 0;
            dp[1] = 1;

            // loop in choices
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[N];
        }
    }
}
