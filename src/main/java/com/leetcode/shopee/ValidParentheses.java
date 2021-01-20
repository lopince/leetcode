package com.leetcode.shopee;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        String s = "{[]}";

        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }

    private static class Solution {

        public boolean isValid(String s) {

            if (s == null || s.length() == 0) {
                return true;
            }

            if (s.length() % 2 != 0) {
                return false;
            }

            Stack<Character> stack = new Stack<>();
            char[] charArray = s.toCharArray();
            for (char cur : charArray) {

                if (cur == ')' && stack.peek() == '(') {
                    stack.pop();

                } else if (cur == ']' && stack.peek() == '[') {
                    stack.pop();

                } else if (cur == '}' && stack.peek() == '{') {
                    stack.pop();

                } else {
                    stack.add(cur);
                }
            }

            return stack.empty();
        }
    }
}
