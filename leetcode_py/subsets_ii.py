class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.ret = []
        self.dfs([], nums)
        
        return self.ret
        
    def dfs(self, cur, nums):
        
        if cur not in self.ret:
            print cur
            self.ret.append(cur)
        
        n = len(nums)   
        if n > 0:
            for num in nums:
                cur.append(num)
                nums.remove(num)
                self.dfs(cur, nums)
                cur.remove(num)
                nums.append(num) 

nums = [1,2,2]

s = Solution()
subsets = s.subsetsWithDup(nums)

print subsets