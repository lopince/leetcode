package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 2, 6, 1};

        Solution solution = new Solution();
        System.out.println(solution.countSmaller(nums));
    }

    private static class Solution {

        public List<Integer> countSmaller(int[] nums) {

            int[] counts = new int[nums.length];

            for (int i = nums.length - 2; i >= 0; i--) {

                int j = i;
                while (nums[j] < nums[j + 1] && j < nums.length - 1) {
                    j++;
                }

                if (j == nums.length - 1) {
                    counts[i] = 0;
                } else {
                    counts[j] = nums[j] > nums[j + 1] ? counts[j + 1] + 1 : counts[j + 1];
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int count : counts) {
                ans.add(count);
            }
            return ans;
        }
    }
}
