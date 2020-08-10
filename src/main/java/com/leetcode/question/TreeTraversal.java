package com.leetcode.question;

import com.leetcode.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;

public class TreeTraversal {

    public static void main(String[] args) {

        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);

        node_1.left = node_2;
        node_1.right = node_3;

        postOrder(node_1, node -> System.out.println(node.val));
        postOrder(node_1, node -> System.out.println(node.val));
    }

    public static void preOrderWithStack(TreeNode root, Consumer<TreeNode> consumer) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.isEmpty()) {

            TreeNode cur = stack.pop();

            consumer.accept(cur);

            stack.push(cur.left);
            stack.push(cur.right);
        }
    }

    public static void inOrderWithStack(TreeNode root, Consumer<TreeNode> consumer) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            consumer.accept(root);
            root = root.right;
        }
    }

    public static void postOrderWithStack(TreeNode root, Consumer<TreeNode> consumer) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Map<TreeNode, Boolean> map = new HashMap<>();

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !map.containsKey(temp.left)) {
                temp = temp.left;
                while (temp != null) {
                    if (map.containsKey(temp)) {
                        break;
                    } else {
                        stack.push(temp);
                    }
                    temp = temp.left;
                }
                continue;
            }
            if (temp.right != null && !map.containsKey(temp.right)) {
                stack.push(temp.right);
                continue;
            }

            TreeNode t = stack.pop();
            consumer.accept(t);
            map.put(t, true);
        }
    }

    public static void preOrder(TreeNode root, Consumer<TreeNode> consumer) {

        if (root != null) {
            consumer.accept(root);
            preOrder(root.left, consumer);
            preOrder(root.right, consumer);
        }
    }

    public static void inOrder(TreeNode root, Consumer<TreeNode> consumer) {

        if (root != null) {
            inOrder(root.left, consumer);
            consumer.accept(root);
            inOrder(root.right, consumer);
        }
    }

    public static void postOrder(TreeNode root, Consumer<TreeNode> consumer) {

        if (root != null) {
            postOrder(root.left, consumer);
            postOrder(root.right, consumer);
            consumer.accept(root);
        }
    }

}
