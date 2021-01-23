package com.leetcode.shopee;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {

        String s = "100[leetcode]";

        Solution solution = new Solution();
        System.out.println(solution.decodeString(s));
    }

    private static class Solution {

        public String decodeString(String s) {

            if (s == null || s.length() < 2) {
                return s;
            }

            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {

                if (Character.isDigit(s.charAt(i))) {

                    String digit = String.valueOf(s.charAt(i));
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        digit += s.charAt(++i);
                    }
                    stack.push(digit);

                } else if (Character.isLetter(s.charAt(i)) || s.charAt(i) == '[') {
                    stack.push(String.valueOf(s.charAt(i)));

                } else if (s.charAt(i) == ']') {

                    String letters = "";
                    while (!stack.peek().equals("[")) {
                        letters = stack.pop() + letters;
                    }

                    stack.pop();

                    int c = Integer.valueOf(stack.pop());
                    String temp = "";
                    while (c-- > 0) {
                        temp += letters;
                    }
                    stack.push(temp);
                }
            }

            String ans = "";
            while (!stack.empty()) {
                ans = stack.pop() + ans;
            }

            return ans;
        }
    }
}
