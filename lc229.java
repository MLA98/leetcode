class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Only moore law could do this in O(n) time, O(1) space;
        int major1, major2, count1, count2;
        major1 = major2 = count1 = count2 = 0;
        for(int num: nums){
            if(count1 == 0 && major2 != num){
                major1 = num;
                count1 ++;
            }
            else if(count2 == 0 && major1 != num){
                major2 = num;
                count2 ++;
            }
            else if(major1 == num){
                count1 ++;
            }
            else if(major2 == num){
                count2 ++;
            }
            else{
                count1 --;
                count2 --;
            }
        }
        count1 = count2 = 0;
        for(int num: nums){
            if(num == major1){
                count1 ++;
            }
            else if(num == major2){
                count2 ++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > nums.length / 3){
            ans.add(major1);
        }
        if(count2 > nums.length / 3){
            ans.add(major2);
        }
        return ans;
    }
}

// 