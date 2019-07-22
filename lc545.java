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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        if(root.left != null){
            leftBoundary(ans, root);
        }
        else{
            ans.add(root.val);
        }
        
        if(root.left != null || root.right != null){
            addLeaves(ans, root);
        }
        
        Stack<Integer> rightB = new Stack();
        rightBoudary(root.right, rightB);
        
        while(!rightB.empty()){
            ans.add(rightB.pop());
        }
        
        return ans;
    }
    
    private void leftBoundary(List<Integer> ans, TreeNode root){
        if(root == null){
            return;
        }
        while(root.left != null){
            ans.add(root.val);
            root = root.left;
        }
        
        if(root.right != null){
            ans.add(root.val);
            leftBoundary(ans, root.right);
        }
    }
    
    private void addLeaves(List<Integer> ans, TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            ans.add(root.val);
        }
        
        addLeaves(ans, root.left);
        addLeaves(ans, root.right);
    }
    
    private void rightBoudary(TreeNode root, Stack<Integer> rightB){
        if(root == null){
            return;
        }
        
        while(root.right != null){
            rightB.push(root.val);
            root = root.right;
        }
        
        if(root.left != null){
            rightB.push(root.val);
            rightBoudary(root.left, rightB);
        }
    }
}