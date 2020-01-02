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
    List<Integer> ans;
    
    private void bfs(TreeNode node, int K) {
        if(node == null) {
            return;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()) {
            int size = q.size();
            if(K == 0) {
                for(TreeNode n1 : q) {
                    ans.add(n1.val);
                }
                return;
            }
            
            K --;
            
            for(int i = 0; i < size; i ++) {
                TreeNode n = q.poll();
                if(n.left != null) {
                    q.offer(n.left);
                }
                
                if(n.right != null) {
                    q.offer(n.right);
                }
            }
        }
    }
    
    private int dfs(TreeNode node, TreeNode target, int K) {
        if(node == null) {
            return -1;
        }
        
        if(node == target) {
            bfs(node, K);
            return 0;
        }
        
        int left = dfs(node.left, target, K);
        int right = dfs(node.right, target, K);
        
        if(left != -1) {
            if(K - left - 2 == -1) {
                ans.add(node.val);
                return -1;
            }
            bfs(node.right, K - left - 2);
            return left + 1;
        }
        
        if(right != -1) {
            if(K - right - 2 == -1) {
                ans.add(node.val);
                return -1;
            }
            bfs(node.left, K - right - 2);
            return right + 1;
        }
        
        return -1;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        
        dfs(root, target, K);
        
        return ans;
    }
}