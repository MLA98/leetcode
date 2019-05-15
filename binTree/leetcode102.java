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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> ans){
        if (root == null){
            return;
        }
        
        // if (ans.get(level) == null){
        //     ans.add(new ArrayList<>());
        // }
        // try{
        //     ans.get(level).add(root.val);
        // }
        // catch(Exception e){
        //     ans.add(new ArrayList<>());
        //     ans.get(level).add(root.val);
        // }
        if (ans.size() <= level){
            ans.add(new ArrayList<>());
            ans.get(level).add(root.val);
        }
        else{
            ans.get(level).add(root.val);
        }
        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);
    }
}

// Don't use try catch since it would slow down the speed because the java's optimization won't work. The program would be 
// Super slow!
