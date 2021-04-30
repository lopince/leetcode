class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dict = {}
        for num in nums:
            if num in dict:
                if dict[num] == 2:
                    dict.pop(num)
                else:
                    dict[num] += 1
            else:
                dict[num] = 1
        
        return dict.keys()[0]


nums = [0,1,0,1,0,1,99]

s = Solution()
print(s.singleNumber(nums))