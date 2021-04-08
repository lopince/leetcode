# -*- coding: utf-8 -*-

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)

        low = 0
        high = n - 1

        while low < high:
            pivot = (low + high) / 2
            if nums[pivot] >= nums[high]:
                low = pivot + 1
            else:
                high = pivot

        return nums[low]


nums = [3, 4, 5, 1, 2]
# nums = [4, 5, 6, 7, 0, 1, 2]
# nums = [3, 1, 2]
print (nums)

s = Solution()
print s.findMin(nums)
