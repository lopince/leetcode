class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i = 0
        j = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[j] = nums[i]
                j += 1
                
        return j
        
nums = [0,1,2,2,3,0,4,2]
val = 2

s = Solution()
r = s.removeElement(nums, val)
print r
print nums[:r]