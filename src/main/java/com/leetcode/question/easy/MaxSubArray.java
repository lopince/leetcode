package com.leetcode.question.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }

    private static class Solution {

        public int maxSubArray(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);

            return max(nums, 0, nums.length - 1);
        }

        private int max(int[] nums, int low, int high) {

            if (low >= high) return nums[low];

            int mid = (low + high) / 2;


            int leftSum = max(nums, low, mid - 1);
            int rightSum = max(nums, mid + 1, high);
            int maxSum = Math.max(leftSum, rightSum);

            if ((high - low + 1) % 2 == 0) {
                maxSum = Math.max(maxSum, maxSum + nums[mid]);
            }

            log.info("low: {}, mid: {}, high: {}, maxSum: {}", low, mid, high, maxSum);

            return maxSum;
        }
    }
}
