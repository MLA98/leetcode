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
    // It seems easier than I thought. It is medium?
    // When you find the problem is not that easy when it is medium,
    // Watch OUT!
    // One shot.
    
    // Going to do it with rercursion.
    // EDGE CASE!!!
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recHelper(ans, root, 1);
        return ans;
    }
    
    private void recHelper(List<Integer> ans, TreeNode root, int level){
        if(root == null){
            return;
        }
        if (ans.size() == level - 1){
            ans.add(root.val);
        }
        
        recHelper(ans, root.right, level + 1);
        recHelper(ans, root.left, level + 1);
    }
}