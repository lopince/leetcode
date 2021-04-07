#coding:utf-8
import numpy as np

class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        
        m = len(matrix)
        n = len(matrix[0])
        
        col = set()
        row = set()
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    col.add(i)
                    row.add(j)
                    
        print col
        print row
                    
        for c in col:
            for j in range(n):
                matrix[int(c)][j] = 0
        for r in row:
            for i in range(m):
                matrix[i][int(r)] = 0
        
        return matrix
    
    def printIn(self, matrix):
        for i in range(len(matrix)):
            print matrix[i]
                    
matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        
s = Solution()
s.printIn(s.setZeroes(matrix))
        
    