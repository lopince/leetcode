package com.leetcode.solution.dp;

import com.leetcode.bean.TreeNode;

import java.net.Socket;
import java.util.HashMap;

public class HouseRobber3 {

    public static void main(String[] args) {

        TreeNode node_1_3 = new TreeNode(3);
        TreeNode node_2_2 = new TreeNode(2);
        TreeNode node_2_3 = new TreeNode(3);
        TreeNode node_3_3 = new TreeNode(3);
        TreeNode node_3_1 = new TreeNode(1);

        node_1_3.left = node_2_2;
        node_1_3.right = node_2_3;

        node_2_2.right = node_3_3;
        node_2_3.right = node_3_1;

        Solution solution = new Solution();
        System.out.println(solution.rob(node_1_3));
    }

    private static class Solution {

        HashMap<TreeNode, Integer> selected;
        HashMap<TreeNode, Integer> unselected;

        public int rob(TreeNode root) {

            selected = new HashMap<>();
            unselected = new HashMap<>();

            dfs(root);

            return Math.max(selected.getOrDefault(root, 0), unselected.getOrDefault(root, 0));
        }

        public void dfs(TreeNode cur) {

            if (cur != null) {

                dfs(cur.left);
                dfs(cur.right);

                selected.put(
                        cur,
                        cur.val + unselected.getOrDefault(cur.left, 0) + unselected.getOrDefault(cur.right, 0));
                unselected.put(
                        cur,
                        Math.max(selected.getOrDefault(cur.left, 0), unselected.getOrDefault(cur.left, 0))
                                + Math.max(selected.getOrDefault(cur.right, 0), unselected.getOrDefault(cur.right, 0)));
            }
        }
    }
}
