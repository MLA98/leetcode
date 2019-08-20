// Naive approach O(n) O(log(n)) recursive approach
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return dfs(root);
    }
    
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        
        return 1 + dfs(node.left) + dfs(node.right);
    }
}


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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int l = leftDepth(root.left);
        int r = leftDepth(root.right);
        
        if(l == r){
            // left sub tree is full;
            // but right sub is probably not
            return (1 << l) + countNodes(root.right);
        }
        
        // right sub tree is full;
        // but left is not
        
        return (1 << r) + countNodes(root.left);
    }
    
    private int leftDepth(TreeNode node){
        int h = 0;
        while(node != null){
            h ++;
            node = node.left;
        }
        
        return h;
    }
}