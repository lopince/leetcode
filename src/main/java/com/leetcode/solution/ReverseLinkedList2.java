package com.leetcode.solution;

import com.leetcode.bean.ListNode;

public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ListNode head = ListNode.gen(1, 2, 3, 4, 5);
        int m = 2;
        int n = 4;

        Solution solution = new Solution();
        ListNode cur = solution.reverseBetween(head, m, n);
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private static class Solution {

        public ListNode reverseBetween(ListNode head, int m, int n) {



            return head;
        }
    }
}
