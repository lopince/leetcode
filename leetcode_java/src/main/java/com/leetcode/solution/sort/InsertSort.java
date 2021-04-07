package com.leetcode.solution.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] nums = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Before: " + Arrays.toString(nums));

        sort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    private static void sort(int[] nums) {

        int len = nums.length;

        for (int i = 1; i < len; i++) {

            // search the correct position for nums[i] in nums[0 ... i-1]
            int j = i;
            int temp = nums[i];
            while (j > 0 && temp < nums[j - 1]) {

                // compare and move nums[j ... i-1] backward
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = temp;
        }
    }
}
