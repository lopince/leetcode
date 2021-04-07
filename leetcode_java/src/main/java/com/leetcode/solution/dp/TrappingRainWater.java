package com.leetcode.solution.dp;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Solution solution = new Solution();
        System.out.println(solution.trap(height));
    }

    private static class Solution {

        public int trap(int[] height) {

            if (height == null || height.length == 0) {
                return 0;
            }

            int len = height.length;
            int sum = 0;

            int[] lMax = new int[len];
            lMax[0] = height[0];
            for (int i = 1; i < len; i++) {
                lMax[i] = Math.max(lMax[i - 1], height[i]);
            }

            int[] rMax = new int[len];
            rMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                rMax[i] = Math.max(rMax[i + 1], height[i]);
            }

            for (int i = 1; i < len - 1; i++) {
                sum += (Math.min(rMax[i], lMax[i]) - height[i]);
            }

            return sum;
        }
    }
}
