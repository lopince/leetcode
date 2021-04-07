package com.leetcode.solution;

import com.leetcode.bean.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

        int[] nums = new int[]{-10, -3, 0, 5, 9};

        Solution solution = new Solution();
        System.out.println(solution.sortedArrayToBST(nums));
    }

    private static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {

            // 二叉搜索树的中序遍历是升序序列

            return trace(nums, 0, nums.length - 1);
        }

        private TreeNode trace(int[] nums, int l, int r) {

            if (l <= r) {
                int mid = (l + r + 1) / 2;

                TreeNode root = new TreeNode(nums[mid]);
                root.left = trace(nums, l, mid - 1);
                root.right = trace(nums, mid + 1, r);

                return root;
            }

            return null;
        }
    }
}
