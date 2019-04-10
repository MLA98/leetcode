class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # easy binary search
        
        l = 0
        r = len(nums) - 1
        ans = []
        
        
        while l <= r:
            mid = l + (r - l) / 2
            if target == nums[mid]:
                for i in range(l, r + 1):
                    if nums[i] == target:
                        ans.append(i)
                        break
                for j in range(r, l - 1, -1):
                    if nums[j] == target:
                        ans.append(j)
                        break
                return ans
            if target > nums[mid]:
                l = mid + 1
            else:
                r = mid - 1
        
        return [-1, -1]
