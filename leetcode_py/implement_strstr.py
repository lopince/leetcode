class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        n, m = len(haystack), len(needle)
        
        for i in range(n - m + 1):
            j = 0
            k = i
            while j < m and haystack[k] == needle[j]:
                j += 1
                k += 1
                
            if j == m:
                return i
            
        return -1
        

        

haystack = "hello"
needle = "ll"

s = Solution()
print s.strStr(haystack, needle)