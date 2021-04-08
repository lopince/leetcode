# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=-1, next=None):
        self.val = val
        self.next = next
         
    def __str__(self):
        return str(self.val)
    
    @staticmethod
    def gen(list):
        head = ListNode()
        cur = head
        if len(list) > 0:
            for e in list:
                node = ListNode(e)
                cur.next = node
                cur = node
                
        return head.next

    @staticmethod
    def list(head):
        list = []
        while head != None:
            list.append(head.val)
            head = head.next
        
        return list
        

# head = ListNode.gen([1,2,3,3,4,4,5])
# while head != None:
#     print head.val
#     head = head.next
