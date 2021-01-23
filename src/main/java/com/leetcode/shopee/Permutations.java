package com.leetcode.shopee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        Solution solution = new Solution();
        List<List<Integer>> ans = solution.permute(nums);
        ans.forEach(System.out::println);
    }

    private static class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {

            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }

            backtrace(list, 0);

            return ans;
        }

        private void backtrace(List<Integer> nums, int i) {

            if (i == nums.size() - 1) {
                ans.add(new ArrayList<>(nums));

            } else {

                for (int j = i; j < nums.size(); j++) {

                    Collections.swap(nums, i, j);
                    backtrace(new ArrayList<>(nums), i + 1);
                    Collections.swap(nums, i, j);
                }
            }
        }
    }
}
