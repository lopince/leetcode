package com.leetcode.solution;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }

    private static class Solution {

        public int maxArea(int[] height) {

            int i = 0;
            int j = height.length - 1;
            int max = 0;

            while (i < j) {

                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);

                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }

            return max;
        }
    }
}
