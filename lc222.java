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
    // I don't really understand the reason creating this kind of tree
    // Sure I need to utilize its features to make to algorithm faster.
    // 这哥们确实有点牛逼哦
    
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = leftDepth(root.left);
        int r = leftDepth(root.right);
        
        if(l == r){
            return countNodes(root.right) + (1<<l);
        }
        return countNodes(root.left) + (1<<r);
    }
    
    private int leftDepth(TreeNode root){
        int h = 0;
        while(root != null){
            h ++;
            root = root.left;
        }
        return h;
    }
}