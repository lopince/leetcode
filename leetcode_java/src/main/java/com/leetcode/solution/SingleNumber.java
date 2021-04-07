package com.leetcode.solution;

import java.util.HashSet;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 1, 2, 1, 2};

        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }

    private static class Solution {

        public int singleNumber(int[] nums) {

            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (!set.add(num)) {
                    set.remove(num);
                }
            }

            return (int) set.toArray()[0];
        }
    }
}
