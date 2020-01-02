class Solution {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private int quickSelect(int nums[], int a, int b, int k) {
        if(b == a){
            return nums[a];
        }
        
        Random rand = new Random();
        int randNumber = rand.nextInt(b - a) + a;
        int pivot = randNumber;
        int smallI = a;
        
        
        swap(nums, pivot, b);
        for(int i = a; i <= b; i ++) {
            if(nums[i] < nums[b]) {
                swap(nums, smallI, i);
                smallI ++;
            }
        }
        
        swap(nums, smallI, b);
        pivot = smallI;
        
        if(pivot == k) {
            return nums[pivot];
        }
        else if(pivot <= k) {
            return quickSelect(nums, pivot + 1, b, k);
        }
        else{
            return quickSelect(nums, a, pivot - 1, k);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        // Convert it into a kth min problem.
        
        int minK = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, minK);
    }
}