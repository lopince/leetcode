# -*- coding: utf-8 -*-
class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        n = len(stones)

        # dp[i][j] 表示青蛙能否到达 i，且从 i-2 到 i-1 的跳跃距离为 j
        dp = [[False] * (n) for i in range(n)]
        dp[0][0] = True

        for i in range(1, n):
            if stones[i] - stones[i - 1] > i:
                return False

        for i in range(1, n):
            for j in range(i - 1, -1, -1):

                # dis 为青蛙当前跳跃的距离
                dis = stones[i] - stones[j]
                if dis > j + 1:
                    break

                # 若青蛙能从 i-1 ~ i 需要跳跃距离为dis, 则在 i-2 ~ i-1 的跳跃过程中，青蛙的跳跃距离只能为 dis-1, dis, dis+1
                dp[i][dis] = dp[j][dis - 1] or dp[j][dis] or dp[j][dis + 1]

        ans = False
        for j in range(n):
            ans = ans or dp[n - 1][j]

        for i in range(n):
            print(dp[i])

        return ans


stones = [0,1,3,5,6,8,12,17]

s = Solution()
print(s.canCross(stones))
