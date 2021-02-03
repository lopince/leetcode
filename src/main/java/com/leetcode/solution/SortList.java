package com.leetcode.solution;

import com.leetcode.bean.ListNode;

public class SortList {

    public static void main(String[] args) {

        ListNode head = ListNode.gen(4, 2, 1, 3);

        Solution solution = new Solution();
        ListNode sortedHead = solution.sortList(head);

        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }

    }

    private static class Solution {

        public ListNode sortList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = cut(head);
            ListNode further = mid.next;
            mid.next = null;

            ListNode l = sortList(head);
            ListNode r = sortList(further);

            return merge(l, r);
        }

        private ListNode cut(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode slow = head;
            ListNode fast = head.next.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        private ListNode merge(ListNode l1, ListNode l2) {

            ListNode stub = new ListNode(-1);
            ListNode cur = stub;

            while (l1 != null && l2 != null) {

                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }

                cur = cur.next;
            }

            cur.next = l1 != null ? l1 : l2;

            return stub.next;
        }


    }
}
