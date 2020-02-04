package com.leetcode.solutions;

import com.leetcode.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
//        int[] candidates = new int[]{2, 3, 6, 7};
//        int target = 7;

        int[] candidates = new int[]{36, 24, 22, 27, 21, 43, 32, 40, 47, 30, 28, 20, 29, 41, 34, 31, 48, 44, 37, 23, 38, 26, 49, 35, 45, 42, 46};
        int target = 71;

        Solution solution = new Solution();
        System.out.println(JsonUtils.toString(solution.combinationSum(candidates, target)));
    }

    static class Solution {

        List<List<Integer>> combinations;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            combinations = new ArrayList<>();

            List<Integer> rest = new ArrayList<>();
            for (int ele : candidates) {
                rest.add(ele);
            }

            for (int ele : candidates) {
                List<Integer> singletonList = new ArrayList<>();
                singletonList.add(ele);
                combine(singletonList, ele, rest, target);
            }

            return combinations;
        }

        private void combine(List<Integer> current, Integer currentMax, List<Integer> rest, Integer target) {

            int sum = 0;
            for (int ele : current) {
                sum += ele;
            }

            if (sum == target) {
                combinations.add(new ArrayList<>(current));

            } else {
                for (Integer restEle : rest) {

                    if (restEle >= currentMax) {

                        if (target == (sum + restEle)) {
                            List<Integer> copy = new ArrayList<>(current);
                            copy.add(restEle);
                            combinations.add(copy);
                        }

                        if (target > (sum + restEle)) {
                            List<Integer> copy = new ArrayList<>(current);
                            copy.add(restEle);
                            combine(copy, restEle, rest, target);
                        }
                    }
                }
            }
        }
    }
}
