package com.leetcode.question;

import com.leetcode.bean.TreeNode;

import java.util.Stack;

public class IsValidBST {

    public static void main(String[] args) {

        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);

        node_2.left = node_3;
        node_2.right = node_3;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(node_2));
    }

    private static class Solution {

        public boolean isValidBST(TreeNode root) {

            if (root == null) {
                return false;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;

            while (root != null || !stack.isEmpty()) {

                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                if (pre != null) {
                    if (pre.val >= root.val) {
                        return false;
                    }
                }
                pre = root;

                root = root.right;
            }

            return true;
        }
    }
}
