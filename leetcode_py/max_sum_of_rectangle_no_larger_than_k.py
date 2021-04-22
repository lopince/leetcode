from sortedcontainers import SortedList

class Solution(object):
    def maxSumSubmatrix(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        ans = float("-inf")
        
        m = len(matrix)
        n = len(matrix[0])
        
        for i in range(m):
            
            col_sums = [0] * n
            for j in range(i, m):
                
                for k in range(n):
                    col_sums[k] += matrix[j][k]
                
                sl = SortedList([0])
                s = 0
                for col_sum in col_sums:
                    s += col_sum
                    
                    bl = sl.bisect_left(s - k)
                    if bl != len(sl):
                        ans = max(ans, s - sl[bl])
                        
                    sl.add(s)
                    
            return ans
                    
                    
                

        
        print(m, n)
        
matrix = [[2,2,-1]]
k = 3

s = Solution()
print s.maxSumSubmatrix(matrix, k)

