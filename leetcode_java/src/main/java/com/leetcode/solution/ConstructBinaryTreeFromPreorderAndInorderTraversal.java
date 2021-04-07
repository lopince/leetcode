package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] inorder = new int[]{9, 3, 15, 20, 7};

//        int[] preorder = new int[]{1, 2};
//        int[] inorder = new int[]{1, 2};

        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};

//        int[] preorder = new int[]{1, 2, 3, 4};
//        int[] inorder = new int[]{1, 2, 3, 4};

//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] inorder = new int[]{9, 3, 15, 20, 7};

        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println(root);
    }

    /*
     * pre order:
     *    root, left, right
     *
     * in order:
     *    left, root, right
     */

    private static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }

            return build(preorder, 0, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int pre_start, int[] inorder, int in_start, int in_end) {

            if (pre_start >= preorder.length
                    || in_start < 0
                    || in_start >= inorder.length
                    || in_end < 0
                    || in_end >= inorder.length
                    || in_start > in_end) {
                return null;
            }

            if (in_start == in_end) {
                return new TreeNode(inorder[in_start]);
            }

            int rootVal = preorder[pre_start];
            int rootIndex = in_start;
            for (; rootIndex <= in_end; rootIndex++) {
                if (inorder[rootIndex] == rootVal) {
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, pre_start + 1, inorder, in_start, rootIndex - 1);
            root.right = build(preorder, pre_start + 1 + (rootIndex - in_start), inorder, rootIndex + 1, in_end);

            return root;
        }
    }
}
