package com.leetcode.shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }

    private static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {

            if (nums == null || nums.length < 4) {
                return new ArrayList<>();
            }

            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();
            for (int k = 0; k < nums.length; k++) {

                if (nums[k] >= 0) {
                    break;
                }

                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }

                int i = 0;
                int j = nums.length - 1;
                while (i < j) {

                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]) {
                        }

                    } else if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]) {
                        }

                    } else {
                        ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[++i]) {
                        }
                        while (i < j && nums[j] == nums[--j]) {
                        }
                    }
                }
            }

            return ans;
        }
    }

}
