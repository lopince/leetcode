package com.leetcode.solution;

import com.leetcode.bean.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = ListNode.gen(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = ListNode.gen(9, 9, 9, 9);

        Solution solution = new Solution();
        ListNode l = solution.addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

    private static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1);
            ListNode cur = head;

            int carry = 0;

            while (l1 != null && l2 != null) {

                int val = (l1.val + l2.val + carry) % 10;
                ListNode temp = new ListNode(val);
                cur.next = temp;
                cur = temp;

                carry = (l1.val + l2.val + carry) / 10;

                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode rest = l1 == null ? l2 : l1;
            while (rest != null) {

                int val = (rest.val + carry) % 10;
                ListNode temp = new ListNode(val);
                cur.next = temp;
                cur = temp;

                carry = (rest.val + carry) / 10;

                rest = rest.next;
            }

            if (carry > 0) {
                cur.next = new ListNode(carry);
            }

            return head.next;
        }
    }
}
