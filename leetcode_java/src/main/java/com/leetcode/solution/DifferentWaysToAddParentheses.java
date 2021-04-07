package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {

        String input = "2*3-4*5";

        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute(input));
    }

    private static class Solution {

        public List<Integer> diffWaysToCompute(String input) {

            if (input == null || input.length() == 0){
                return new ArrayList<>();
            }

            List<String> ops = new ArrayList<>();

            for (int i = 0; i < input.length();) {

                if (!Character.isDigit(input.charAt(i))) {
                    ops.add(input.substring(i, i + 1));
                    i++;

                    // is digit
                } else {
                    int k = i;
                    while (++k < input.length() && Character.isDigit(input.charAt(k))) {
                    }
                    ops.add(input.substring(i, k));
                    i = k;
                }
            }

            if (ops.size() == 1){
                return Collections.singletonList(Integer.parseInt(ops.get(0)));
            }

            return dfs(ops);
        }

        private List<Integer> dfs(List<String> ops) {

            if (ops.size() == 1) {
                return Collections.singletonList(Integer.parseInt(ops.get(0)));
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < ops.size(); i += 2) {

                List<Integer> l = dfs(ops.subList(0, i));
                List<Integer> r = dfs(ops.subList(i + 1, ops.size()));

                String op = ops.get(i);
                for (Integer le : l){
                    for (Integer re: r){

                        Integer res = cal(le, re, op);
                        if (res != null){
                            ans.add(res);
                        }
                    }
                }

            }

            return ans;
        }

        private Integer cal(int num1, int num2, String op) {

            if ("+".equals(op)) {
                return num1 + num2;

            } else if ("-".equals(op)) {
                return num1 - num2;

            } else if ("*".equals(op)) {
                return num1 * num2;
            }

            return num1;
        }
    }
}
