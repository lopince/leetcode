package com.leetcode.solution;

public class ContainerWithMostWater {

    private static class Solution {
        public int maxArea(int[] height) {
            if (height == null || height.length == 0){
                return 0;
            }

            int l = 0;
            int r = height.length - 1;
            int maxArea = 0;

            while (l < r) {

                maxArea = Math.max(Math.abs(l - r) * Math.min(height[l], height[r]), maxArea);

                if (height[l] > height[r]) {
                    r--;
                } else {
                    l++;
                }
            }

            return maxArea;
        }
    }
}
