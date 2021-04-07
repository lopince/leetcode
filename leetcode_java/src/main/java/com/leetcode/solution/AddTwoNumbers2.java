package com.leetcode.solution;

import com.leetcode.bean.ListNode;

import java.util.Stack;

public class AddTwoNumbers2 {

    public static void main(String[] args) {

        ListNode l1 = ListNode.gen(7,2,4,3);
        ListNode l2 = ListNode.gen(5, 6 , 4);

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(l1, l2);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Stack<Integer> s1 = new Stack<>();
            ListNode cur = l1;
            while (cur != null){
                s1.push(cur.val);
                cur = cur.next;
            }

            Stack<Integer> s2 = new Stack<>();
            cur = l2;
            while (cur != null){
                s2.push(cur.val);
                cur = cur.next;
            }

            int carry = 0;
            ListNode stub = new ListNode(-1);
            while (!s1.empty() && !s2.empty()){

                int val = s1.pop() + s2.pop() + carry;
                carry = val / 10;
                val = val % 10;

                cur = new ListNode(val);

                cur.next = stub.next;
                stub.next = cur;
            }

            if (!s1.empty() || !s2.empty()){

                Stack<Integer> rest = s1.empty() ? s2 : s1;
                while (!rest.empty()){

                    int val = rest.pop() + carry;
                    carry = val / 10;
                    val = val % 10;

                    cur = new ListNode(val);

                    cur.next = stub.next;
                    stub.next = cur;
                }
            }

            if (carry > 0){
                cur = new ListNode(carry);

                cur.next = stub.next;
                stub.next = cur;
            }

            return stub.next;
        }
    }
}
