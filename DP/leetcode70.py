class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        # brute force
#         def helper(n):
#             way = 0
#             if n == 0:
#                 return 1
            
#             if (n < 0):
#                 return 0
#             else:
#                 way = way + helper(n - 1) + helper(n - 2)
#             return way
#         return helper(n)
                    
        # dp attempt
        # bottom-up attempt: try to get the possibilty each step
        possib = [1, 1]
        for i in range(2, n + 1):
            if (i - 2 >= 0):
                possib.append(possib[i - 1] + possib[i - 2])
        
        return possib[n]
            
            
