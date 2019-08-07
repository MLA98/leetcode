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
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }
    
    private boolean dfs(TreeNode node){
        // base case: leaf
        if(node == null){
            return true;
        }
        
        int rightVal = node.right == null? node.val: 
                                            node.right.val;
        int leftVal = node.left == null? node.val: 
                                            node.left.val;
        
        boolean leftUni = dfs(node.left);
        boolean rightUni = dfs(node.right);
        
        
        if (leftUni && rightUni && 
            leftVal == rightVal && leftVal == node.val){
            count ++;
            return true;
        }
            
        return false;
    }
}