package com.leetcode.shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 2, 6, 1};

        Solution solution = new Solution();
        System.out.println(solution.countSmaller(nums));
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    private static class Solution {

        private HashMap<Integer, Integer> map = new HashMap<>();

        public List<Integer> countSmaller(int[] nums) {

            int[] temp = Arrays.copyOf(nums, nums.length);

            mergeSort(nums);

            List<Integer> ans = new ArrayList<>();
            for (int num : temp) {
                ans.add(map.getOrDefault(num, 0));
            }

            return ans;
        }

        private void mergeSort(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
        }

        private void mergeSort(int[] nums, int left, int right) {

            if (left < right) {

                int mid = (left + right) >> 1;
                mergeSort(nums, left, mid);
                mergeSort(nums, mid + 1, right);
                merge(nums, left, mid, right);
            }
        }

        private void merge(int[] nums, int left, int mid, int right) {

            int i = left;
            int j = mid + 1;

            int k = 0;
            int[] temp = new int[nums.length];

            while (i <= mid && j <= right) {

                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];

                } else {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + (right - j + 1));
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
}
