package com.leetcode.solution.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int len = nums.length;

            int[] dp = new int[len];
            Arrays.fill(dp, 1);

            int max = 1;
            for (int i = 1; i < len; i++) {

                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }

                max = Math.max(dp[i], max);
            }

            return max;
        }
    }
}
