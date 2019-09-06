class Solution {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        
        dfs(root, p.val, q.val);
        return ans;
    }
    
    private int dfs(TreeNode root, int val1, int val2){
        if(root == null){
            return 0;
        }
        
        int left = dfs(root.left, val1, val2);
        int right = dfs(root.right, val1, val2);
        int ret = 0;
        if(root.val == val1){
            ret = 1;
        }
        else if(root.val == val2){
            ret = 2;
        }

        if(left + right + ret == 3 && ans == null){
            ans = root;
        }
        
        return left + right + ret;
    }
}