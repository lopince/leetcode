package com.leetcode.shopee;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.removeKdigits(num, k));
    }

    private static class Solution {
        public String removeKdigits(String num, int k) {

            Stack<Character> stack = new Stack<>();
            for (char cur : num.toCharArray()) {

                if (k > 0 && !stack.isEmpty() && cur < stack.peek()) {
                    stack.pop();
                    k--;
                }

                if (cur != '0' || !stack.isEmpty()) {
                    stack.push(cur);
                }
            }

            while (k-- > 0 && !stack.isEmpty()) {
                stack.pop();
            }

            String ans = "";
            while (!stack.isEmpty()) {
                ans = stack.pop() + ans;
            }

            return ans.length() == 0 ? "0" : ans;
        }
    }
}
