class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        dict = {}
        dict[1000] = 'M'
        dict[900] = 'CM'
        dict[500] = 'D'
        dict[400] = 'CD'
        dict[100] = 'C'
        dict[90] = 'XC'
        dict[50] = 'L'
        dict[40] = 'XL'
        dict[10] = 'X'
        dict[9] = 'IX'
        dict[5] = 'V'
        dict[4] = 'IV'
        dict[1] = 'I'
        
        roman = ''
        for key in dict.keys():
            c = int(num / key)
            if c > 0:
                for i in range(c):
                    roman = roman + dict[key]
                num -= (c * key)
                
        return roman
        
        
s = Solution()
print(s.intToRoman(1994))