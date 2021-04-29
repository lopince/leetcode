class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        n = len(nums)
        ban = []
        for i in range(n):
            sign = True

            queue = [i]
            j = (i + (n + nums[i])) % n

            while j not in queue and j not in ban:
                queue.append(j)

                if not ((nums[j] > 0) is (nums[i] > 0)):
                    sign = False
                    break

                j = (j + (n + nums[j])) % n

            if sign and len(queue) > 1 and j == queue[0] and j not in ban:
                print(queue)
                return True
            else:
                ban.append(i)

        return False


nums = [1,1,2]

s = Solution()
print(s.circularArrayLoop(nums))
