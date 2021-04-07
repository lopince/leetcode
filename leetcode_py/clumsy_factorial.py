class Solution(object):
    def clumsy(self, N):
        """
        :type N: int
        :rtype: int
        """
        stack = [N]
        i = 0
        N -= 1
        while N > 0:
            print stack
            if i % 4 == 0:
                stack.append(stack.pop() * N)
            elif i % 4 == 1:
                if stack[-1] < 0:
                    stack.append(-(-stack.pop() // N))
                else:
                    stack.append(stack.pop() // N)
            elif i % 4 == 2:
                stack.append(N)
            else:
                stack.append(-N)
            N -= 1
            i += 1

        sum = 0
        while stack:
            sum += stack.pop()

        return sum


N = 4

s = Solution()
print s.clumsy(N)

print -30 // 4
print 30 // 4