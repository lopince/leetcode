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

    private static void mergeSort(int[] nums, int left, int right, int[] temp) {

        if (left < right) {

            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            sort(nums, left, mid, right, temp);
        }
    }

    private static void sort(int[] nums, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        k = 0;
        while (left <= right) {
            nums[left++] = temp[k++];
        }
    }
}
