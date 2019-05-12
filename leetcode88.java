class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // heck, it is easy, but I could not solve it!!!
        m --;
        n --;
        int k = m + n + 1;
        while (m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]){
                nums1[k] = nums1[m];
                m --;
                k --;
            }
            else{
                nums1[k] = nums2[n];
                n --;
                k --;
            }
        }
        
        while (m == -1 && n >= 0){
            nums1[k] = nums2[n];
            n --;
            k --;
        }
    }
}
