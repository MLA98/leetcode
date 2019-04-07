class Solution(object):
    def removeDuplicates(self, nums):
        
        if len(nums) == 0:
            return 0
        i = 0
        pre_num = -213129391
        while (i < len(nums)):
            if nums[i] != pre_num:
                pre_num = nums[i]
                i = i + 1
            else:
                del nums[i]
                
