from TreeNode import TreeNode


class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        k_x, parent_x = self.dfs(None, root, 0, x)
        k_y, parent_y = self.dfs(None, root, 0, y)

        print(k_x, parent_x.val)
        print(k_y, parent_y.val)

        if k_x == k_y:
            if parent_x != parent_y:
                return True

        return False

    def dfs(self, parent, cur, k, target):
        if cur is not None:
            if cur.val == target:
                return k, parent

            k_ans, parent_ans = self.dfs(cur, cur.left, k + 1, target)
            if k_ans is not None:
                return k_ans, parent_ans

            return self.dfs(cur, cur.right, k + 1, target)

        return None, None


root = TreeNode.gen([1, 2, 3, None, 4])
x = 2
y = 3

s = Solution()
print(s.isCousins(root, x, y))
