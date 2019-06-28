/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(1) O(1)  Space: O(n) solution
class BSTIterator {
    ArrayList<Integer> sorted;
    int index;
    
    public BSTIterator(TreeNode root) {
        this.sorted = new ArrayList<Integer>();
        this.inorder(root);
        this.index = -1;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        this.inorder(root.left);
        this.sorted.add(root.val);
        this.inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        this.index ++;
        return this.sorted.get(this.index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.sorted.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 // O(1) O(1){May be O(n) as we push all nodes on the right side, However. the average case would be O(1) as we don't push more}
 // space: O(height) as the stack would be released. When we push, we only push one side nodes whose number is equal to n.
class BSTIterator {
    Stack<TreeNode> stack;
        
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.inorderPush(root);
    }
    
    private void inorderPush(TreeNode root){
        while(root != null){
            this.stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode result = this.stack.pop();
        if (result.right != null){
            this.inorderPush(result.right);
        }
        return result.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */