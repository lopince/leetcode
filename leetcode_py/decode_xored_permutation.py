class Solution(object):
    def decode(self, encoded):
        """
        :type encoded: List[int]
        :rtype: List[int]
        """
        n = len(encoded)

        perm_xor_sum = 0
        for i in range(1, n + 2):
            perm_xor_sum ^= i

        encoded_xor_sum = 0
        for i in range(1, n, 2):
            encoded_xor_sum ^= encoded[i]

        perm = []
        perm.append(perm_xor_sum ^ encoded_xor_sum)

        for i in range(0, n):
            perm.append(perm[i] ^ encoded[i])

        return perm


encoded = [3, 1]
s = Solution()
print(s.decode(encoded))
