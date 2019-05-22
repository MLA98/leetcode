class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || inorder.length==0 || preorder.length==0) return null;
        int rootVal = preorder[0];
        int rootIndex = -1;
        TreeNode root = new TreeNode(rootVal);
        if(preorder.length==1) return root;
        for (int i = 0; i < inorder.length; i ++){
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        int[] subleftin   = Arrays.copyOfRange(inorder,0,rootIndex);
        int[] subrightin   = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] subleftpre = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] subrightpre = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        root.left = buildTree(subleftpre, subleftin);
        root.right = buildTree(subrightpre, subrightin);
        return root;
    }
}
