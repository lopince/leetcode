package com.leetcode.solutions;

import com.leetcode.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        Solution2 solution = new Solution2();
        System.out.println(solution.permute(nums));

    }

    // 普通递归
    static class Solution {

        List<List<Integer>> permutes;

        public List<List<Integer>> permute(int[] nums) {

            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }

            permutes = new ArrayList<>();

            if (list.size() == 1) {
                permutes.add(list);
            } else {
                permute(list);
            }

            return permutes;
        }


        private void permute(List<Integer> nums) {

            for (Integer num : nums) {

                List<Integer> current = new ArrayList<>();
                current.add(num);

                List<Integer> rest = new ArrayList<>(nums);
                rest.remove(num);

                permute(current, rest);
            }
        }

        private void permute(List<Integer> current, List<Integer> rest) {

            if (rest.size() == 1) {
                List<Integer> copyCurrent = new ArrayList<>(current);
                copyCurrent.add(rest.get(0));
                permutes.add(copyCurrent);

            } else {
                for (Integer restNum : rest) {
                    List<Integer> copyCurrent = new ArrayList<>(current);
                    List<Integer> copyRest = new ArrayList<>(rest);

                    copyCurrent.add(restNum);
                    copyRest.remove(restNum);

                    permute(copyCurrent, copyRest);
                }
            }
        }
    }

    // 回溯法
    static class Solution2 {

        List<List<Integer>> permutes;

        public List<List<Integer>> permute(int[] nums) {

            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }

            permutes = new ArrayList<>();

            if (current.size() == 1) {
                permutes.add(current);
            } else {
                backtrack(0, current);
            }

            return permutes;
        }


        private void backtrack(int index, List<Integer> current) {

            int n = current.size() - 1;

            if (index == n) {
                permutes.add(new ArrayList<>(current));
            } else {
                for (int i = index; i < current.size(); i++) {
                    Collections.swap(current, i, index);
                    backtrack(index + 1, current);

                    // 还原，以供下一个位置的回溯使用
                    Collections.swap(current, i, index);
                }
            }
        }
    }
}
