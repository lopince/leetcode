class Solution(object):
    def minCount(self, coins):
        """
        :type coins: List[int]
        :rtype: int
        """
        c = 0
        for coin in coins:
            c += (coin / 2 + coin % 2)
        return c

s = Solution()
print s.minCount([2, 3, 10])
            