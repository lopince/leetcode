from cmath import sqrt

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        a = 0
        b = int(c ** 0.5)
        while a <= b:
            tmp = a * a + b * b
            if tmp == c:
                return True
            elif tmp < c:
                a += 1
            else:
                b -= 1
        
        return False
        

c = 5

s = Solution()
print(s.judgeSquareSum(c))