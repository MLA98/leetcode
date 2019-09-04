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

// Astonishing that I thought it was super easy
// Fast actually but used a lot of space.
class Solution {
    // sb force anyways
    List<List<Integer>> levelOrder;
    public List<Integer> rightSideView(TreeNode root) {
        levelOrder = new ArrayList<>();
        levelOrderTrav(root, 0);
        List<Integer> ans = new LinkedList<>();
        for(List<Integer> level: levelOrder){
            ans.add(level.get(0));
        }
        return ans;
    }
    
    private void levelOrderTrav(TreeNode node, int level){
        if(node == null){
            return;
        }
        
        if(level >= levelOrder.size()){
            levelOrder.add(new ArrayList<>());
        }
        
        levelOrder.get(level).add(node.val);
        
        levelOrderTrav(node.right, level + 1);
        levelOrderTrav(node.left, level + 1);
    }
}