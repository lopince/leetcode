from ListNode import ListNode


class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        
        list = []
        cur = head
        while cur != None:
            list.append(cur.val)
            cur = cur.next
        n = len(list)
        
        tmp = [1] * n
        
        for i in range(n):
            tmp[(i + k) % n] = list[i]
        
        head = ListNode()
        cur = head
        if len(tmp) > 0:
            for e in tmp:
                node = ListNode(e)
                cur.next = node
                cur = node
    
        return head.next


head = ListNode.gen([1,2,3,4,5])
k = 2

s = Solution()
head = s.rotateRight(head, k)

print ListNode.list(head)