class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        if m == 0 and n == 0:
            return []
        elif m == 0:
            return nums2
        elif n == 0:
            return nums1
        
        temp = []
        i, j = 0, 0
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                temp.append(nums1[i])
                i += 1
            else:
                temp.append(nums2[j])
                j += 1
                
        if i < m:
            temp.extend(nums1[i:])
        
        if j < n:
            temp.extend(nums2[j:])
            
        return temp

nums1 = [1,2,3,0,0,0]
m = 3
nums2 = [2,5,6]
n = 3

s = Solution()
print s.merge(nums1, m, nums2, n)