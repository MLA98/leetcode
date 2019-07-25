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
    private List<Integer> ans;
    private int K;
    private TreeNode target;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.ans = new ArrayList<>();
        this.K = K;
        this.target = target;
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode node){
        if(node == this.target){
            findLower(node, 0);
            return 1;
        }
        
        if(node == null){
            return -1;
        }
        
        int L = dfs(node.left);
        int R = dfs(node.right);
        
        if(L > this.K || R > this.K){
            return -1;
        }
        
        if(L != -1){
            if(L == this.K){
                this.ans.add(node.val);
            }
            else if(L < this.K){
                findLower(node.right, L + 1);
            }
            
            return L + 1;
        }
        else if(R != -1){
            if(R == this.K){
                this.ans.add(node.val);
            }
            else if(R < this.K){
                findLower(node.left, R + 1);
            }
            
            return R + 1;
        }
        
        return -1;
    }
    
    private void findLower(TreeNode target, int dist){
        if(target == null){
            return;
        }
        
        if(dist == this.K){
            this.ans.add(target.val);
        }
        else{
            findLower(target.left, dist + 1);
            findLower(target.right, dist + 1);
        }
    }
}