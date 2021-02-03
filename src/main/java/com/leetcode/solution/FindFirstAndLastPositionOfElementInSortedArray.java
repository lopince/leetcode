package com.leetcode.solution;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }

    private static class Solution {

        public int[] searchRange(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int i = 0;
            int j = nums.length - 1;

            while (i < nums.length && nums[i] != target) {
                i++;
            }

            if (i == nums.length) {
                return new int[]{-1, -1};
            }

            while (j >= 0 && nums[j] != target) {
                j--;
            }

            return new int[]{i, j};
        }
    }
}
