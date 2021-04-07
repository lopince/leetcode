class Solution(object):
    def numRabbits(self, answers):
        """
        :type answers: List[int]
        :rtype: int
        """
        dict = {}
        for answer in answers:
            if dict.has_key(answer):
                dict[answer] += 1
            else:
                dict[answer] = 1

        print dict
        sum = 0
        for k, v in dict.items():
            if k == 0:
                sum += v
            else:
                if v <= k + 1:
                    sum += k + 1
                else:
                    if v % (k + 1) != 0:
                        sum += (k + 1) * ((v / (k + 1)) + 1)
                    else:
                        sum += (k + 1) * ((v / (k + 1)))

        return sum


answers = [0,0,1,1,1]
s = Solution()
print s.numRabbits(answers)
