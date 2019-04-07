class Solution(object):
    def twoSum(self, nums, target):
        dic = {}
        for i, j in enumerate(nums):
            complement = target - j
            if complement in dic:
                return [dic[complement], i]
            else:
                dic[j] = i
            
                
