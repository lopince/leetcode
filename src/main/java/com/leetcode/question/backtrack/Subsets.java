package com.leetcode.question.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        Solution solution = new Solution();
        System.out.println(solution.subsets(nums));
    }

    private static class Solution {

        private List<List<Integer>> res;

        public List<List<Integer>> subsets(int[] nums) {

            res = new ArrayList<>();

            backtrack(nums, new LinkedList<>());

            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> tracks) {

            if (!res.contains(tracks)) {
                System.out.println(tracks);

                this.res.add(new LinkedList<>(tracks));
            }

            for (int num : nums) {

                if (tracks.contains(num)
                        || (!tracks.isEmpty() && tracks.getLast() >= num)) {
                    continue;
                }

                tracks.add(num);

                backtrack(nums, tracks);

                tracks.removeLast();
            }
        }
    }
}
