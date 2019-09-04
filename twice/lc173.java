// Sb force, inorder traversal
// O(n) O(n) in initiated.

class BSTIterator {
    private List<Integer> list;
    private int index = 0;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        inorder(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        index ++;
        return list.get(index - 1);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index >= list.size()){
            return false;
        }
        
        return true;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}



 // O(1) O(1){May be O(n) as we push all nodes on the right side, However. the average case would be O(1) as we don't push more}
 // space: O(height) as the stack would be released. When we push, we only push one side nodes whose number is equal to n.

 class BSTIterator {
    Stack<TreeNode> stack = new Stack();
    
    public BSTIterator(TreeNode root) {
        if(root != null){
            inorderPush(root);
        }
    }
    
    private void inorderPush(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode ret = stack.pop();
        
        if(ret.right != null){
            inorderPush(ret.right);
        }
        
        return ret.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }
        
        return true;
    }
}