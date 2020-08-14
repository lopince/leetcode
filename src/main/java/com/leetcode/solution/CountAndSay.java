package com.leetcode.solution;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class CountAndSay {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int counter = 1; counter <= 30; counter++) {
            System.out.println(counter + ". " + solution.countAndSay(counter));
        }

    }

    private static class Solution {

        private String countAndSay(int n) {

            if (n == 1) {
                return "1";
            }

            String pre = countAndSay(n - 1);
            StringBuilder res = new StringBuilder();
            int i = 0;
            for (; i < pre.length(); ) {

                int j = 1;
                while (i + j < pre.length() && pre.charAt(i) == pre.charAt(i + j)) {
                    j++;
                }

                res.append(j).append(pre.charAt(i));
                i += j;
            }

            return res.toString();
        }
    }
}
