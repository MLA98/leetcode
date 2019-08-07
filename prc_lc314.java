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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        // BFS
        Queue<Integer> cols = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        int min = 0;
        int max = 0;
        
        cols.offer(0);
        nodes.add(root);
        
        while(!cols.isEmpty()){
            TreeNode node = nodes.poll();
            int col = cols.poll();
            
            min = Math.min(col, min);
            max = Math.max(col, max);
            
            
            if(map.containsKey(col)){
                map.get(col).add(node.val);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(node.val);
                map.put(col, temp);
            }
            
            if(node.left != null){
                cols.offer(col - 1);
                nodes.offer(node.left);
            }
            
            if(node.right != null){
                cols.offer(col + 1);
                nodes.offer(node.right);
            }
        }
        
        for(int i = min; i <= max; i ++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
}