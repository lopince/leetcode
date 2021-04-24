import time
from sortedcontainers import SortedList


class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # i, j, k
        # ai < ak < aj
        left_min = nums[0]
        # o(nlogn)
        right_list = SortedList(nums[1:])
        
        # o(n)
        for j in range(1, len(nums) - 1):
            right_list.remove(nums[j])
            
            if left_min < nums[j]: 
                # o(logn)
                index = right_list.bisect_right(left_min)
                # print "Testing [%s, nums[%s]=%s, nums[%s]=%s]" % (left_min, j, nums[j], index, right_list[index])
                if index < len(right_list) and right_list[index] < nums[j] and left_min < right_list[index]:
                    return True
            else:
                left_min = nums[j]    
                
        return False
            
            
nums = [1, 2, 3, 4]

start_time = int(round(time.time() * 1000))

s = Solution()
print(s.find132pattern(nums))


print('time cost: ', int(round(time.time() * 1000)) - start_time, 'ms')
