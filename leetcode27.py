class Solution(object):
    def removeElement(self, nums, val):
        len_nums = len(nums)
        i = 0
        while(i < len_nums):
            if nums[i] == val:
                del nums[i]
                len_nums = len_nums - 1
            else:
                i = i + 1
                
        
        return len(nums)
            
