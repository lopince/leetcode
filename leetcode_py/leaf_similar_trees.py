import TreeNode


class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        seq1 = self.getSeq(root1)
        seq2 = self.getSeq(root2)
        
        print(seq1)
        print(seq2)
        
        if len(seq1) == len(seq2):
            for i in range(len(seq1)):
                if seq1[i] != seq2[i]:
                    return False
        else:
            return False
    
        return True
    
    def getSeq(self, root):
        seq = []
        
        stack = []
        cur = root
        while cur or len(stack) > 0:
            while cur:
                stack.append(cur)
                cur = cur.left
            if len(stack) > 0:
                cur = stack.pop()
                if cur.left is None and cur.right is None:
                    seq.append(cur.val)
                cur = cur.right
        
        return seq


root1 = TreeNode.TreeNode(1)
root2 = TreeNode.TreeNode(2)

s = Solution()
print(s.leafSimilar(root1, root2))
