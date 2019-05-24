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
    public int minDepth(TreeNode root) {
        return findMinDepth(root);
        
        
    }
    
    private int findMinDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        // return 1 + Math.min(findMinDepth(root.left), findMinDepth(root.right));
        int left = findMinDepth(root.left);
        int right = findMinDepth(root.right);
        if (left == 0 || right ==0){
            return left + right + 1;
        }
        else{
            return Math.min(left, right) + 1;
        }
    }
}
