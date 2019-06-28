class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer up, Integer bot){
        if (root == null){
            return true;
        }
        
        if (up != null && up <= root.val){
            return false;
        }
        if (bot != null && bot >= root.val){
            return false;
        }
        return helper(root.left, root.val, bot) && helper(root.right, up, root.val);
    }
}



// hec!! It is binary search tree, the right subtrees' all elements have to be larger than the root.
// Quite abstract.


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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderHelper(inorder, root);
        if(root == null){
            return true;
        }
        int pre = inorder.get(0);
        for(int i = 1; i < inorder.size(); i ++){
            if(pre >= inorder.get(i)){
                return false;
            }
            pre = inorder.get(i);
        }
        return true;
    }
    
    private void inorderHelper(List<Integer> inorder, TreeNode root){
        if(root == null){
            return;
        }
        inorderHelper(inorder, root.left);
        inorder.add(root.val);
        inorderHelper(inorder, root.right);
    }
}


// Inorder: great intuitive that bst's inorder traversal is sorted.
// Next time: try to solve it with stack; therefore you could examine the bst without storing it into a list.