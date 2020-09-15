package com.leetcode.solution.dfs;

import java.util.HashMap;

public class CombinationNumber {

    public static void main(String[] args) {

        System.out.println(c(10, 3));
    }

    /**
     * C(n, m)
     * Base on recurrence formula C(n,m) = C(n-1,m-1) + C(n-1,m)
     * The process of recurse is same as dfs, so using a dictionary to prune the search tree
     */
    private static int c(int n, int m) {

        return c(n, m, new HashMap<>());
    }

    private static int c(int n, int m, HashMap<String, Integer> dic) {

        if (n < m) {
            return 0;
        }

        if (n == m) {
            return 1;
        }

        if (m == 0) {
            return 1;
        }

        String key = getKey(n, m);
        if (dic.containsKey(key)) {
            return dic.get(key);
        } else {
            int res = c(n - 1, m - 1) + c(n - 1, m);
            dic.put(key, res);
            return res;
        }
    }

    private static String getKey(int n, int m) {
        return n + "#" + m;
    }
}
