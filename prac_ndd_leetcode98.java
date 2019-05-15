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
