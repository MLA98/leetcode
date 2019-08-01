// Time: O(m + n);
// Space: O(m)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        for(int i = 0; i < m; i ++){
            nums1Copy[i] = nums1[i];
        }
        
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        
        while(index < m + n){
            int val1 = p1 < m? nums1Copy[p1]: Integer.MAX_VALUE;
            int val2 = p2 < n? nums2[p2]: Integer.MAX_VALUE;
            nums1[index] = val1 < val2? val1: val2;
            index ++;
            if(val1 < val2){
                p1 ++;
            }
            else{
                p2 ++;
            }
        }
    }
}


// Time: O(m + n)
// Space: O(1)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        
        while(index >= 0){
            int val1 = p1 >= 0? nums1[p1]: Integer.MIN_VALUE;
            int val2 = p2 >= 0? nums2[p2]: Integer.MIN_VALUE;
            nums1[index] = val1 < val2? val2: val1;
            index --;
            if(val1 < val2){
                p2 --;
            }
            else{
                p1 --;
            }
        }
    }
}