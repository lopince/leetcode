class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        n = len(matrix)
        m = len(matrix[0])
        
        # O(n+m)
        if  matrix[0][0] <= target or target >= matrix[n - 1][m - 1]:
           
            col = 0
            while col < n and (target < matrix[col][0] or target > matrix[col][m - 1]):
                col += 1

            if col < n:
                for i in range(m):
                    if matrix[col][i] == target:
                        return True
        return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 13

# matrix = [[1]]
# target = 3

s = Solution()
print s.searchMatrix(matrix, target)