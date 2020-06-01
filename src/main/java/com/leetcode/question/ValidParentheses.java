package com.leetcode.question;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(new Solution().isValid(s));
    }

    private static class Solution {

        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);
                if (!stack.isEmpty()) {
                    if (')' == c && '(' == stack.peek()
                            || '}' == c && '{' == stack.peek()
                            || ']' == c && '[' == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
}
