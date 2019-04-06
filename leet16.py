class Solution(object):
    def threeSumClosest(self, nums, target):
        nums.sort()
        sums = nums[0] + nums[2] + nums[1]
        
        for i in range(len(nums)-2):
            p1 = i + 1
            p2 = len(nums) - 1
            while(p1 != p2):
                temp_sum = nums[p1] + nums[p2] + nums[i]
                if temp_sum == target:
                    return temp_sum
                
                if abs(temp_sum - target) < abs(sums - target):
                    sums = temp_sum
                
                if temp_sum < target:
                    p1 += 1
                elif temp_sum > target:
                    p2 -= 1
                
        return sums
                
