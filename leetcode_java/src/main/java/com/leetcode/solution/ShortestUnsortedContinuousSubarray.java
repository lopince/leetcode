package com.leetcode.solution;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 3, 3};

        Solution solution = new Solution();
        System.out.println(solution.findUnsortedSubarray(nums));
    }

    private static class Solution {

        public int findUnsortedSubarray(int[] nums) {

            if (nums == null || nums.length < 2) {
                return 0;
            }

            // 有序数组1 + 无序数组 + 有序数组2
            int len = nums.length;

            int max = Integer.MIN_VALUE;
            int q = 0;
            for (int i = 0; i < nums.length; i++) {

                // 有序数组2 中的元素，应大于max
                if (max <= nums[i]) {
                    max = nums[i];
                } else {

                    // max >= nums[i]，说明nums[i]不属于 有序数组2
                    q = i;
                }
            }

            int min = Integer.MAX_VALUE;
            int p = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {

                if (min >= nums[i]) {
                    min = nums[i];
                } else {
                    p = i;
                }
            }


            return q == 0 && p == nums.length - 1 ? 0 : q - p + 1;
        }
    }
}
