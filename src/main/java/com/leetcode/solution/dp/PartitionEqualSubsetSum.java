package com.leetcode.solution.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    private static class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();

            if (sum % 2 != 0) {
                return false;
            }

            int halfSum = (sum) / 2;

            // dp[i][j]: 对于前i个物品，能否恰好装满重量为j的背包
            boolean[] dp = new boolean[halfSum + 1];

            // base case
            dp[0] = true;

            System.out.println(halfSum);

            for (int i = 0; i < n; i++) {
                for (int j = halfSum; j >= 0; j--) {
                    if (j - nums[i] >= 0) {

                        dp[j] = dp[j - nums[i]] || dp[j];
                    }
                }
            }

            return dp[halfSum];
        }
    }
}
