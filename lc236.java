/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 
class Solution {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
    
    private boolean dfs(TreeNode traverse, TreeNode p, TreeNode q){
        if(traverse == null){
            return false;
        }
        int mid, left, right;
        left = this.dfs(traverse.left, p, q) ? 1 : 0;
        right = this.dfs(traverse.right, p, q) ? 1 : 0;
        mid = traverse == p || traverse == q ? 1 : 0;
        if(mid + left + right >= 2){
            this.ans = traverse;
        }
        if(mid + left + right > 0){
            return true;
        }
        return false;
    }
}