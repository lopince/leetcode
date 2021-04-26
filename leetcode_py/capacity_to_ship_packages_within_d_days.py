class Solution(object):
    def shipWithinDays(self, weights, D):
        """
        :type weights: List[int]
        :type D: int
        :rtype: int
        """
        left = max(weights)
        right = sum(weights)

        while left < right:

            mid = (left + right) / 2

            d = 1
            w = 0
            for weight in weights:
                if w + weight > mid:
                    w = 0
                    d += 1

                w += weight

            if d <= D:
                right = mid
            else:
                left = mid + 1

        return left


weights = [1, 2, 3, 1, 1]
D = 4

s = Solution()
print(s.shipWithinDays(weights, D))
