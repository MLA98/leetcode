class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        # root is the core of this problem.
        ans = [1, 1]
        
        for i in xrange(2, n + 1):
            temp_ans = 0
            for j in xrange(1, i + 1):
                l = j - 1
                r = i - j
                temp_ans = ans[j - 1] * ans[i - j] + temp_ans
            ans.append(temp_ans)
                
        return ans[n]
        
