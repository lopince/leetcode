package com.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};

        Solution solution = new Solution();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution {

        public void sortColors(int[] nums) {

            if (nums == null || nums.length < 2){
                return;
            }

            TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o));

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                int num = entry.getKey();
                int c = entry.getValue();
                while (c-- > 0) {
                    nums[i++] = num;
                }
            }
        }
    }
}
