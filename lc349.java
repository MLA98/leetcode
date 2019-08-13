// time: O(m + n) transform to sets;
// space: O(m + n) sets

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> ansList = new LinkedList<>();
        
        for(int num1: nums1){
            set1.add(num1);
        }
        
        for(int num2: nums2){
            set2.add(num2);
        }
        
        for(int setNum1: set1){
            if(set2.contains(setNum1)){
                ansList.add(setNum1);
            }
        }
        
        int[] ans = new int[ansList.size()];
        int index = 0;
        
        for(int ansNum: ansList){
            ans[index] = ansNum;
            index ++;
        }
        
        return ans;
    }
}


// sb force O(m * n)/ space: O(m + n)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        for(int num1: nums1){
            for(int num2: nums2){
                if(num1 == num2)
                    set.add(num1);
            }
        }
        
        int[] ans = new int[set.size()];
        int i = 0;
        
        for(int key: set){
            ans[i] = key;
            i ++;
        }
        
        return ans;
    }
}

