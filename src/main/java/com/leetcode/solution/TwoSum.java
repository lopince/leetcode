package com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    private static class Solution {

        public int[] twoSum(int[] nums, int target) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                } else {
                    map.put(target - nums[i], i);
                }
            }

            return new int[]{-1, -1};
        }
    }
}
