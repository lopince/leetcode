package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = new int[]{2,2,1,1,1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }

    private static class Solution {


        public int majorityElement(int[] nums) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int target = nums.length / 2 + 1;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() >= target){
                    return entry.getKey();
                }
            }

            return nums[0];
        }
    }
}
