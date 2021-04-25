class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        nums = sorted(nums)

        maxSize = 1
        maxVal = nums[0]

        dp = [1] + [0] * (n - 1)
        for i in range(1, n):
            dp[i] = 1
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    dp[i] = max(dp[i], dp[j] + 1)

            if dp[i] > maxSize:
                maxSize = dp[i]
                maxVal = nums[i]

        print('dp: {}'.format(dp))
        print('maxSize: {}'.format(maxSize))
        print('maxVal: {}'.format(maxVal))

        res = []
        for i in range(n - 1, -1, -1):
            if dp[i] == maxSize and maxVal % nums[i] == 0:
                res.insert(0, nums[i])
                maxVal = nums[i]
                maxSize -= 1

        return res


nums = [3,4,16,8]

s = Solution()
print s.largestDivisibleSubset(nums)
