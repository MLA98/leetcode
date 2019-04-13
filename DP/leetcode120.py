class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        # tri_len = len(triangle) - 1
        # ans = [0] * len(triangle[tri_len])
        ans = [0] * (len(triangle) + 1)        
        for i in triangle[::-1]:
            for j in range(len(i)):
                ans[j] = i[j] + min(ans[j], ans[j + 1])
        
        return ans[0]
                
