// O(n) solution is shitty
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        
        while(p1 < m || p2 < n){
            int val1 = p1 < m? nums1[p1]: Integer.MAX_VALUE;
            int val2 = p2 < n? nums2[p2]: Integer.MAX_VALUE;
            if(val1 > val2){
                arr[i] = val2;
                i ++;
                p2 ++;
            }
            else{
                arr[i] = val1;
                i ++;
                p1 ++;
            }
        }
        
        if((m + n) % 2 == 0){
            double a1 = arr[(m + n) / 2];
            double a2 = arr[(m + n) / 2 - 1];
            double ans = (a1 + a2) / 2;
            return ans;
        }
        
        return arr[(m + n) / 2];
    }
}

