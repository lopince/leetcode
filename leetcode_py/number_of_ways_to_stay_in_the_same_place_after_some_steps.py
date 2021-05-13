class Solution(object):
    def numWays(self, steps, arrLen):
        """
        :type steps: int
        :type arrLen: int
        :rtype: int
        """
        # dp[i][j] 代表 指针在索引i处 已走j步 的情况下，指针仍指向索引0处的方案数
        # dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + dp[i + 1][j - 1]

        mod = 10 ** 9 + 7
        max_col = min(arrLen - 1, steps)
        max_dis = min(steps / 2, arrLen - 1)

        dp = [[0] * (max_col + 1) for _ in range(steps + 1)]
        dp[0][0] = 1

        for i in range(1, steps + 1):
            
            bound = min(i, max_dis)
            for j in range(0, bound + 1):
                dp[i][j] = dp[i - 1][j]
                if j - 1 >= 0:
                    dp[i][j] = (dp[i][j] + dp[i-1][j - 1]) % mod
                if j + 1 <= max_col:
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod

        for col in dp:
            print(col)

        return dp[steps][0]


steps = 3
arrLen = 2

s = Solution()
print(s.numWays(steps, arrLen))
