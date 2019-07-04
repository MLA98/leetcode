// inorder solution
class Solution {
    // Easiest: inorder
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inList = new ArrayList<>();
        inorder(root, inList);
        return inList.get(k - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> inList){
        if(root == null){
            return;
        }
        inorder(root.left, inList);
        inList.add(root.val);
        inorder(root.right, inList);
    }
}

// Add a size check. if the size of the list is already larger than what we want, return;

class Solution {
    // Easiest: inorder
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inList = new ArrayList<>();
        inorder(root, inList, k);
        return inList.get(k - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> inList, int k){
        if(root == null){
            return;
        }
        if(inList.size() >= k){
            return;
        }
        inorder(root.left, inList, k);
        inList.add(root.val);
        inorder(root.right, inList, k);
    }
}

// Use queue or stack to avoid the use of the ArrayList.
class Solution {
    // Easiest: inorder
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k --;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }
    }
    
}