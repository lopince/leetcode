package com.leetcode.solution;

import com.leetcode.bean.ListNode;

public class RemoveDuplicatedFromSortedList {

    public static void main(String[] args) {

        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(1);
        ListNode node2_1 = new ListNode(2);

        node1_1.next = node1_2;
        node1_2.next = node2_1;

        Solution solution = new Solution();

        ListNode cur = solution.deleteDuplicates(node1_1);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static class Solution {

        public ListNode deleteDuplicates(ListNode head) {

            if(head == null){
                return null;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null) {

                if (slow.val != fast.val) {
                    slow.next = fast;
                    slow = slow.next;
                }

                fast = fast.next;
            }

            slow.next = null;

            return head;
        }
    }
}
