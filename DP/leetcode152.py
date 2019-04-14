class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        max_s = [0] * len(nums)
        min_s = [0] * len(nums)
        max_s[0] = nums[0]
        min_s[0] = nums[0]
        for i in range(1, len(nums)):
            if nums[i] >= 0:
                max_s[i] = max(max_s[i - 1] * nums[i], nums[i])
                min_s[i] = min(min_s[i - 1] * nums[i], nums[i])
            else:
                max_s[i] = max(min_s[i - 1] * nums[i], nums[i])
                min_s[i] = min(max_s[i - 1] * nums[i], nums[i])
            
        
        return max(max_s)
