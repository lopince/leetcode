class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        dp = [1] + [0] * target
        for i in range(1, target + 1):
            for num in nums:
                if i >= num:
                    dp[i] += dp[i-num]

        return dp[target]


nums = [1, 2, 3]
target = 4

s = Solution()
print(s.combinationSum4(nums, target))
