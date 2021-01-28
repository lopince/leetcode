package com.leetcode.shopee;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 4, 9, 8, 5, 6, 7};
        System.out.println(Arrays.toString(nums));

        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {

        if (l < r) {
            int k = partition(nums, l, r);
            quickSort(nums, l, k - 1);
            quickSort(nums, k + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {

        int p = nums[r];

        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= p) {
                i++;
                swap(nums, i, j);
            }
        }

        i++;
        swap(nums, i, r);

        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
