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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        
        for(int i = 1; i < ans.size(); i += 2){
            Collections.reverse(ans.get(i));
        }
        
        return ans;
    }
}