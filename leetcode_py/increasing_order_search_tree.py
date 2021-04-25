class Solution(object):
    def increasingBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        stack = []
        stub = TreeNode(-1)
        cur = stub
        while(root != None or len(stack) != 0):
            while root != None:
                stack.append(root)
                root = root.left
            if len(stack) != 0:
                root = stack.pop()
                
                temp = TreeNode(root.val)
                cur.right = temp
                cur = temp
                
                root = root.right
        
        return stub.right