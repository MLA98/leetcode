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
    // BFS could solve it easily apparently
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
            return ans;
        }
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> layer = new ArrayList<>();
            for(int i = 0; i < size; i ++){
                TreeNode node = q.poll();
                layer.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            ans.add(layer);
        }
        
        return ans;
    }
}