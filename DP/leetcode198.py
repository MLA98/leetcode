class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        ans = []
        for i in range(len(nums)):
            if i == 0:
                ans.append(nums[i])
            elif i == 1:
                ans.append(nums[i])
            else:
                ans.append(max(ans[0 : i - 1]) + nums[i])
                
        return max(ans)

    
    
    class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        ans = []
        for i in range(len(nums)):
            if i == 0:
                ans.append(nums[i])
            elif i == 1:
                ans.append(nums[i])
            else:
                if i == 2:
                    ans.append(ans[i - 2] + nums[i])
                else:
                    ans.append(max(ans[i - 2], ans[i-3]) + nums[i])
                
        return max(ans)
