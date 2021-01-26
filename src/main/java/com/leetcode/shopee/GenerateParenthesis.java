package com.leetcode.shopee;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {

        int n = 3;

        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(n);
        ans.forEach(System.out::println);
    }

    private static class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {

            dfs("", n, n);

            return ans;
        }

        private void dfs(String str, int left, int right) {

            if (left == 0 && right == 0) {
                ans.add(str);
                return;
            }

            if (left > 0) {
                dfs(str + "(", left - 1, right);
            }

            if (right > left) {
                dfs(str + ")", left, right - 1);
            }
        }
    }
}
