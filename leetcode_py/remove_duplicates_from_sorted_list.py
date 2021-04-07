from ListNode import ListNode

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        
        tmp = ListNode(-1, head)
        pre = tmp
        cur = head
        
        while cur != None:
            while cur.next != None and cur.val == cur.next.val:
                cur = cur.next
            pre.next = cur
            pre = cur
            cur = cur.next
            
        return tmp.next

head = ListNode.gen([1,1,2,3,3])

s = Solution()
head = s.deleteDuplicates(head)

while head != None:
    print head
    head = head.next