// awesome enough. At leaset u solved it.
class Solution {
    int[] inorder;
    int[] preorder;
    int preIndex = 0;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder_, int[] inorder_) {
        if(preorder_.length == 0){
            return null;
        }
        inorder = inorder_;
        preorder = preorder_;
        int idx = 0;
        for(int val: inorder){
            idx_map.put(val, idx);
            idx ++;
        }
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int l, int r){
        if(l > r){
            return null;
        }
        else if(l == r){
            preIndex ++;
            return new TreeNode(inorder[l]);
        }
        
        int rootI = idx_map.get(preorder[preIndex]);
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex ++;
        root.left = helper(l, rootI - 1);
        root.right = helper(rootI + 1, r);
        return root;
    }
}