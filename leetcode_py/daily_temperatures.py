class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        n = len(T)
        
        wait_days = [0] * n

        stack = [0]
        for i in range(1, n):
            while len(stack) > 0 and T[i] > T[stack[-1]]:
                pre = stack.pop()
                wait_days[pre] = i - pre
            stack.append(i)
        
        return wait_days    

temperatures = [73, 74, 75, 71, 69, 72, 76, 73]

s = Solution()
wait_days = s.dailyTemperatures(temperatures)

print wait_days
