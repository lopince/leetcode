package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);

        node_1.left = node_2;
        node_1.right = node_5;
        node_2.left = node_3;
        node_2.right = node_4;
        node_5.right = node_6;

        Solution solution = new Solution();
        solution.flatten(node_1);

        System.out.println(node_1);
    }

    private static class Solution {
        public void flatten(TreeNode root) {

            if (root == null){
                return;
            }

            // using pre order traversal to flatten the tree
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            List<TreeNode> list = new LinkedList<>();

            while (!stack.isEmpty()) {

                TreeNode cur = stack.pop();
                System.out.println(cur);
                list.add(cur);

                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }

            TreeNode pre = list.remove(0);
            for (TreeNode node : list){
                pre.right = node;
                pre.left = null;
                pre = node;
            }
        }
    }
}
