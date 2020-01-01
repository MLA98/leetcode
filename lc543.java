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
    private int max = 0;
    
    private int getLongestBranch(TreeNode node) {
        if(node.left == null && node.right == null){
            return 0;
        }
        
        int left = 0;
        int right = 0;
        
        if(node.left != null) {
             left = getLongestBranch(node.left) + 1;
        }
        
        if(node.right != null){
             right = getLongestBranch(node.right) + 1;
        }
        
        int longestBranch = Math.max(right, left);
        max = Math.max(max, right + left);
        
        return longestBranch;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        getLongestBranch(root);
        
        return max;
    }
}