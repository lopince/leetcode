package com.leetcode.solution.dfs;

public class FindTargetSumWays {

    public static void main(String[] args) {

        int[] nums = new int[]{18, 47, 49, 45, 31, 13, 45, 44, 33, 45, 44, 43, 21, 30, 23, 46, 43, 10, 3, 30};
        int s = 23;

        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, s));
    }

    private static class Solution {

        int counter = 0;

        public int findTargetSumWays(int[] nums, int s) {

            backtrack(nums, 0, 0, s);

            return counter;
        }


        private void backtrack(int[] nums, int index, int sum, int target) {

            if (index == nums.length) {
                if (sum == target) {
                    counter++;
                }
                return;
            }

            int cur = nums[index];

            backtrack(nums, index + 1, sum + cur, target);
            backtrack(nums, index + 1, sum - cur, target);
        }
    }
}
