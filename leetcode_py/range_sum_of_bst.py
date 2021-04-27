class Solution(object):
    def rangeSumBST(self, root, low, high):
        """
        :type root: TreeNode
        :type low: int
        :type high: int
        :rtype: int
        """
        return self.dfs(root, low, high)

    def dfs(self, root, low, high):
        if root is None:
            return 0
        
        sum = 0
        if low <= root.val and root.val <= high:
            sum += root.val
        
        sum += self.dfs(root.left, low, high)
        sum += self.dfs(root.right, low, high)
        
        return sum