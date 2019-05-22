class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length / 2]);        
        root.left = helper(nums, 0, nums.length / 2 - 1);
        root.right = helper(nums, nums.length / 2 + 1, nums.length - 1);
        return root;
    }
    
    private TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null; 
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}

// Easy!!
