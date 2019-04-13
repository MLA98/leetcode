class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0
        min_p = prices[0]
        max_p = -999999999
        
        for i in range(1, len(prices)):
            if prices[i] < min_p:
                min_p = prices[i]
            else:
                max_p = max((prices[i] - min_p), max_p)
        
        if max_p < 0:
            return 0
        
        return max_p
        
