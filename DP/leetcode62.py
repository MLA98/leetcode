class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        memo = [ [-1]*n for i in range(m) ]
        
        def helper(m,n):
            # robot = (-m + 1, n - 1)
            path = 0
         
            if m == 0 and n == 0:
                return 1
            if memo[abs(m)][n] != -1:
                return memo[abs(m)][n]
            if m + 1 <= 0:
                path = path + helper(m + 1, n)
            if n - 1 >= 0:
                path = path + helper(m , n - 1)

            memo[abs(m)][n] = path
            return path
        
        
        return helper(-m + 1, n - 1)
