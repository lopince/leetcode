package com.leetcode.solution.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

    public static void main(String[] args) {

        String s = "19216811";

        Solution solution = new Solution();
        solution.restoreIpAddresses(s).forEach(System.out::println);
    }

    private static class Solution {

        private List<String> ipAddresses;

        public List<String> restoreIpAddresses(String s) {

            ipAddresses = new ArrayList<>();

            dfs(s, new LinkedList<>());

            return ipAddresses;
        }

        private void dfs(String s, LinkedList<String> segments) {

            if (segments.size() == 4) {
                if (s.length() == 0) {
                    ipAddresses.add(toIP(segments));
                }
                return;
            }

            if (4 - segments.size() > s.length() || s.length() > 3 * (4 - segments.size())) {
                return;
            }

            for (int i = 0; i < 3 && i < s.length(); i++) {

                String segment = s.substring(0, i + 1);

                if (!(segment.length() > 1 && segment.startsWith("0"))) {
                    int segmentVal = Integer.parseInt(segment);

                    if (0 <= segmentVal && segmentVal <= 255) {
                        segments.addLast(segment);
                        dfs(s.substring(i + 1), segments);
                        segments.removeLast();
                    }
                }
            }
        }

        private String toIP(List<String> ipSegments) {

            return String.format("%s.%s.%s.%s",
                    ipSegments.get(0),
                    ipSegments.get(1),
                    ipSegments.get(2),
                    ipSegments.get(3));

        }
    }
}
