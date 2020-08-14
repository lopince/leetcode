package com.leetcode.solution;


import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);

        root.right = node_2;
        node_2.left = node_3;

        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(root));
    }

    private static class Solution {

        List<Integer> res;

        public List<Integer> inorderTraversal(TreeNode root) {

            this.res = new ArrayList<>();

            inOrderWithStack(root);

            return res;
        }

        // 递归
        public void inOrder(TreeNode root) {

            if (root != null) {
                inOrder(root.left);
                res.add(root.val);
                inOrder(root.right);
            }
        }

        public void inOrderWithStack(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode cur = root;

            while (cur != null || !stack.isEmpty()) {

                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                cur = stack.pop();
                res.add(cur.val);

                cur = cur.right;
            }
        }
    }
}
