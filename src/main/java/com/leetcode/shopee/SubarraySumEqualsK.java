package com.leetcode.shopee;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.subarraySum(nums, k));
    }

    private static class Solution {

        public int subarraySum(int[] nums, int k) {


            if (nums == null || nums.length == 0) {
                return 0;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int sum = 0;
            int ans = 0;
            for (int num : nums) {

                sum += num;
                if (map.containsKey(sum - k)) {
                    ans += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return ans;
        }
    }
}
