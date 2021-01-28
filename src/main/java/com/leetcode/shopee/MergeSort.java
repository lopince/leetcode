package com.leetcode.shopee;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 4, 5, 7, 6, 1, 9};
        System.out.println(Arrays.toString(nums));

        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private static void mergeSort(int[] nums, int l, int r, int[] temp) {

        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid, temp);
            mergeSort(nums, mid + 1, r, temp);
            merge(nums, l, mid, r, temp);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r, int[] temp) {

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= r) {
            temp[k++] = nums[j++];
        }

        k = 0;
        while (l <= r) {
            nums[l++] = temp[k++];
        }
    }
}
