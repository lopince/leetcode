class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m = max(nums)
        nums.sort()

        arr = [0] * (m + 1)
        for num in nums:
            arr[num] += num

        dp = [0] * (m + 1)
        dp[0] = 0
        dp[1] = arr[1]
        
        for i in range(2, m + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])
            
        return dp[m]


nums = [2, 2, 3, 3, 3, 4]

s = Solution()
print(s.deleteAndEarn(nums))
