
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        import sys
        cur_val = -sys.maxint - 1
        max_val = -sys.maxint - 1
        for i in nums:
            cur_val = max(i, cur_val + i) # check if it is necessary to start from new element. 
            max_val = max(cur_val, max_val) # As curvalue proceeds, max keeps updating itself.
        
        return max_val
