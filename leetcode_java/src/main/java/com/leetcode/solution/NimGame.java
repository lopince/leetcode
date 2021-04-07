package com.leetcode.solution;

public class NimGame {

    public static void main(String[] args) {

        int n = 5;

        Solution solution = new Solution();
        System.out.println(solution.canWinNim(n));
    }

    private static class Solution {

        public boolean canWinNim(int n) {

            if (n < 4) {
                return true;
            }

            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            dp[1] = true;
            dp[2] = true;
            dp[3] = true;

            for (int i = 4; i <= n; i++) {
                dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3];
            }

            return dp[n];
        }
    }
}
