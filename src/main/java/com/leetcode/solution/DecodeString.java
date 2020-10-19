package com.leetcode.solution;

import java.util.Stack;

public class DecodeString {

    private static class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            Stack<String> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                char cur = s.charAt(i);
                String curS = String.valueOf(cur);

                if (Character.isDigit(cur)) {

                    char next = s.charAt(i + 1);
                    while (Character.isDigit(next)) {
                        curS = curS + next;
                        i++;
                        next = s.charAt(i + 1);
                    }
                    stack.push(curS);

                } else if (cur == '[' || Character.isLetter(cur)) {
                    stack.push(curS);

                } else if (cur == ']') {

                    String popS = "";
                    while (!stack.peek().equals("[")) {
                        popS = stack.pop() + popS;
                    }

                    // pop '['
                    stack.pop();

                    // pop '3'
                    String temp = "";
                    int counter = Integer.parseInt(stack.pop());
                    while (counter-- > 0) {
                        temp += popS;
                    }

                    stack.push(temp);
                }
            }

            String ans = "";
            while (!stack.isEmpty()) {
                ans = stack.pop() + ans;
            }

            return ans;
        }
    }
}
