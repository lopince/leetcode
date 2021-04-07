class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        i, j = 1, 1

        c = 1
        pre = nums[0]
        while j < n:

            if pre == nums[j]:
                c += 1
                if c < 3:
                    nums[i] = nums[j]
                    i += 1
            else:
                c = 1
                nums[i] = nums[j]
                i += 1

            pre = nums[j]
            j += 1

        return i


nums = [1, 1, 1, 2, 2, 3]
print nums

s = Solution()
len = s.removeDuplicates(nums)

print nums
print 'removeDuplicates -> nums[:{}]: {}'.format(len, nums[:len])
