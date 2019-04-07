class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        four_nine = {'IV':4, 'IX':9, 'XL':40, 'XC':90, 'CD' : 400, 'CM' :900}
        sym_dic = {"I": 1, "V": 5, "X": 10, "L":50, "C":100, "D":500, "M":1000}
        sum = 0
        iter_list = range(len(s))
        del_count = 0
        for i in iter_list:
            print i
            i2 = i + 1
            if s[i:i2+1] in four_nine:
                print s[i:i2+1]
                sum = sum + four_nine[s[i:i2+1]]
                if len(s) - 1 != i:
                    del iter_list[i + 1 - del_count]
                    del_count = del_count + 1
            else:
                sum = sum + sym_dic[s[i]]
            
        return sum
        # faster
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {'I':1,'V':5, 'X':10, 'L':50, 'C':100, 'D':500,'M':1000}
#        s = s.replace("IV", "IIII").replace("IX", "VIIII")
#        s = s.replace("XL", "XXXX").replace("XC", "LXXXX")
#        s = s.replace("CD", "CCCC").replace("CM", "DCCCC")
        s = s.replace('IV','IIII')
        s = s.replace('IX','VIIII')
        s = s.replace('XL','XXXX')
        s = s.replace('XC','LXXXX')
        s = s.replace('CD','CCCC')
        s = s.replace('CM','DCCCC')
        result = 0
        for i in s:
            result += d[i]
        return result
