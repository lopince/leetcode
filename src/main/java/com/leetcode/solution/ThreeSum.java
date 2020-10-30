package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null) {
                return new ArrayList<>();
            }

            int len = nums.length;

            if (len < 3) {
                return new ArrayList<>();
            }

            // sort
            Arrays.sort(nums);

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {

                if (nums[i] > 0) {
                    break;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = len - 1;
                while (left < right) {

                    int sum = nums[left] + nums[i] + nums[right];
                    if (sum < 0) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else if (sum > 0) {
                        while (left < right && nums[right] == nums[--right]) ;
                    } else {
                        list.add(Arrays.asList(nums[left], nums[i], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }

            }


            return list;
        }
    }
}
