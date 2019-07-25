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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        
        return genHelper(1, n);
    }
    
    private LinkedList<TreeNode> genHelper(int start, int end){
        LinkedList<TreeNode> ans = new LinkedList<TreeNode>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        
        for(int i = start; i <= end; i ++){
            LinkedList<TreeNode> L = genHelper(start, i - 1);
            LinkedList<TreeNode> R = genHelper(i + 1, end);
            
            for(TreeNode l: L){
                for(TreeNode r: R){
                    TreeNode selfNode = new TreeNode(i);
                    selfNode.left = l;
                    selfNode.right = r;
                    ans.add(selfNode);
                }
            }
        }
        
        return ans;
    }
}