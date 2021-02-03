package com.leetcode.solution;

public class PaintFence {

    public static void main(String[] args) {

        int n = 3;
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.numWays(n, k));
    }

    private static class Solution {

        public int numWays(int n, int k) {

            if(n == 0 || k==0){
                return 0;
            }

            if(n==1){
                return k;
            }

            int[] dp = new int[n + 1];
            dp[1] = k;
            dp[2] = k * k;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
            }

            return dp[n];
        }
    }
}
