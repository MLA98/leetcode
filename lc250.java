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
    int count;
    
    private boolean isUni(TreeNode root){
        // bottom case
        if(root.left == null && root.right == null){
            count ++;
            return true;
        }
        
        boolean left = true;
        boolean right = true;
        if(root.left != null){
            left = isUni(root.left) && root.val == root.left.val;
        }
        
        if(root.right != null){
            right = isUni(root.right) && root.val == root.right.val;
        }
        
        if(right && left){
            count ++;
            return true;
        }
        
        return false;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        count = 0;  
        isUni(root);
        return count;
    }
    
}