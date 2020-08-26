package com.leetcode.solution.dp;

public class MaximumProductSubarray {

    private static class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int dpMax = nums[0];
            int dpMin = nums[0];

            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {

                int temp = dpMax;
                dpMax = Math.max(Math.max(dpMax * nums[i], dpMin * nums[i]), nums[i]);
                dpMin = Math.min(Math.min(temp * nums[i], dpMin * nums[i]), nums[i]);

                ans = Math.max(ans, dpMax);
            }

            return ans;

        }
    }
}
