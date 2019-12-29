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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        
        while(!bfsQueue.isEmpty()){
            int layerCount = bfsQueue.size();
            ans.add(new ArrayList<>());
            
            for(int i = 0; i < layerCount; i ++){
                TreeNode node = bfsQueue.poll();
                ans.get(ans.size() - 1).add(node.val);
                if(node.left != null){
                    bfsQueue.offer(node.left);
                }
                
                if(node.right != null){
                    bfsQueue.offer(node.right);
                }
            }
        }
        
        Collections.reverse(ans);
        return ans;
    }
}