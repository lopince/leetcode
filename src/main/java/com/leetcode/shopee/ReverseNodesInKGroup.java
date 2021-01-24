package com.leetcode.shopee;

import com.leetcode.bean.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode head = ListNode.gen(1, 2);

        Solution solution = new Solution();
        head = solution.reverseKGroup(head, 2);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {

            if (k < 2) {
                return head;
            }

            ListNode stub = new ListNode(-1);
            stub.next = head;

            ListNode l = stub;
            ListNode r = stub;
            while (r != null) {

                int c = k;
                ListNode cur = l;
                while (c-- > 0) {
                    cur = cur.next;
                    if (cur == null) {
                        return stub.next;
                    }
                }

                r = cur.next;
                ListNode[] pairs = reverse(l.next, cur);

                l.next = pairs[0];
                pairs[1].next = r;

                l = pairs[1];
            }

            return stub.next;
        }

        private ListNode[] reverse(ListNode l, ListNode r) {

            r.next = null;
            ListNode cur = l;

            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return new ListNode[]{r, l};
        }
    }
}
