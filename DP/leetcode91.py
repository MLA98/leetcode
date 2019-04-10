# class Solution(object):
#     def numDecodings(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
        
#         # bottom-up 
#         if int(s[0]) == 0:
#             return 0
#         else:
#             decode = [1]
#         for i in range(1, len(s)):
#             if int(s[i]) == 0 and int(s[i - 1]) == 0:
#                 decode.append(0)
#             elif 1 <= int(s[i - 1 : i + 1]) <= 26 and int(s[i - 1]) != 0:
#                 decode.append(1 + decode[i - 1])
#             else:
#                 decode.append(decode[i - 1])
        
#         return (decode[len(s) - 1])
class Solution(object):
    def numDecodings(self, s):
        if not s:
            return 0

        dp = [0 for x in range(len(s) + 1)]
        dp[0] = 1
        dp[1] = 1 if 0 < int(s[0]) <= 9 else 0

        for i in range(2, len(s) + 1):
            if 0 < int(s[i-1:i]) <= 9:
                dp[i] += dp[i - 1]
            if s[i-2:i][0] != '0' and int(s[i-2:i]) <= 26:
                dp[i] += dp[i - 2]
        return dp[len(s)]
