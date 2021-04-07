from ListNode import ListNode


class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head

        tHead = ListNode()
        tmp = tHead
        cur = head
        while cur != None:
            if cur.next == None or cur.val != cur.next.val:
                tmp.next = cur
                tmp = cur
            else:
                while cur != None and cur.next != None and cur.val == cur.next.val:
                    cur = cur.next
            cur = cur.next
        tmp.next = None

        return tHead.next


head = ListNode.gen([1,1,1])

s = Solution()
head = s.deleteDuplicates(head)

c = 1
while head != None:
    print head.val
    head = head.next
