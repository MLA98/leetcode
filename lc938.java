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
    private int L;
    private int R;
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;
        inorderHelper(root);
        return sum;
    }
    
    private void inorderHelper(TreeNode root){
        if(root == null){
            return;
        }
        
        inorderHelper(root.left);
        
        if(root.val >= L && root.val <= R){
            sum += root.val;
        }
        
        inorderHelper(root.right);
    }
}