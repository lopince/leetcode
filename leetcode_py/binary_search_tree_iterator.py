from TreeNode import TreeNode

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.index = 0
        self.seq = []
        
        cur = root
        
        stack = []
        stack.append(root)
        
        visited = set()
        
        while len(stack) > 0:
            if cur != None and cur.left != None and cur.left not in visited:
                stack.append(cur.left)
                cur = cur.left
            else:
                cur = stack.pop()
                self.seq.append(cur.val)
                visited.add(cur.left)
                
                if cur.right != None:
                    stack.append(cur.right)
                
    def next(self):
        """
        :rtype: int
        """
        next = self.seq[self.index]
        self.index += 1
        
        return next
        


    def hasNext(self):
        """
        :rtype: bool
        """
        return self.index < len(self.seq)

root = [7, 3, 15, None, None, 9, 20]


iter = BSTIterator(root)
print iter.seq