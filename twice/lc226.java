class Solution {
    // If I could do this, will Google let me in? :)
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}