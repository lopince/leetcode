package com.leetcode.solution;

public class NextPermutation {

    private static class Solution {
        public void nextPermutation(int[] nums) {

            if (nums == null || nums.length < 2){
                return;
            }

            int i = nums.length - 1;
            while (nums[i] <= nums[i - 1] && --i > 0) ;

            if (i != 0) {

                // find first descending
                int min = nums[i];
                int minIndex = i;
                int j = i;
                while (j < nums.length) {

                    if (nums[j] <= min && nums[j] > nums[i - 1]) {
                        min = nums[j];
                        minIndex = j;
                    }

                    j++;
                }

                // swap
                swap(nums, i - 1, minIndex);
            }

            // reserve nums[i, len-1]
            int l = i;
            int r = nums.length - 1;
            while (l < r) {
                swap(nums, l++, r--);
            }
        }

        private void swap(int[] nums, int i, int j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
