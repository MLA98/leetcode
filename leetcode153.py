# 153. Find Minimum in Rotated Sorted Array

# My buggy version:
 class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        len_n = len(nums)
        mid_n = len_n / 2
        first = 0
        while 0 < mid_n < len_n:
            if mid_n == 0 or mid_n == len_n - 1:
                if nums[0] > nums[len_n - 1]:
                    return nums[len_n - 1]
                else:
                    return nums[0]
            elif nums[mid_n - 1] < nums[mid_n] < nums[mid_n + 1]:
                if nums[mid_n] < nums[0] and nums[mid_n] < nums[len_n - 1]:
                    mid_n = mid_n / 2 # go left
                else:
                    mid_n = mid_n + (len_n - mid_n) / 2
            elif nums[mid_n] > nums[mid_n + 1] and nums[mid_n] > nums[mid_n - 1]:   
                first = mid_n + 1
                break
            elif nums[mid_n] < nums[mid_n + 1] and nums[mid_n] < nums[mid_n - 1]:
                first = mid_n
                break
        
        return nums[first]
        
# Solution after looking up the solution:
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
         
        if right == 0:
            return nums[0]
        
        if nums[right] > nums[left]:
            return nums[0]
        
        while (left <= right): 
            mid = left + (right - left)/2

            if nums[mid] < nums[mid - 1]:
                return nums[mid]
            elif nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            
            if nums[mid] > nums[0]:
                left = mid + 1
            else:
                right = mid - 1
