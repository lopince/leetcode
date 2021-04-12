from TreeNode import TreeNode
from Queue import Queue


class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        
        rets = []

        q = Queue()
        q.put(root)

        while not q.empty():

            ret = []

            size = q.qsize()
            while size > 0:

                cur = q.get()
                ret.append(cur.val)

                if cur.right != None:
                    q.put(cur.right)
                if cur.left != None:
                    q.put(cur.left)

                size -= 1
            rets.append(ret)
        
        return rets


root = TreeNode.gen([3, 9, 20, None, None, 15, 7])
print root

s = Solution()
rets = 
