/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        
        TreeNode root = helper(0, nums.length - 1, nums);
        return root;
    }
    
    private TreeNode helper(int left, int right, int[] nums){
        if(left > right){
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode ret = new TreeNode(nums[mid]);
        ret.left = helper(left, mid - 1, nums);
        ret.right = helper(mid + 1, right, nums);
        return ret;
    }
}