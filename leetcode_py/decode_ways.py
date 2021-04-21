class Solution(object):

    def __init__(self):
        self.list = []
        for i in range(1, 27):
            self.list.append(str(i))

    def numDecodings(self, s):

        if s[0] == '0':
            return 0

        n = len(s)
        dp = [1] + [0] * n

        for i in range(1, n + 1):
            if int(s[i - 1]) > 0:
                dp[i] += dp[i-1]

            if i > 1 and int(s[i-2]) != 0 and int(s[i-2:i]) <= 26:
                dp[i] += dp[i-2]

        return dp[n]


string = "2101"

s = Solution()
print s.numDecodings(string)
