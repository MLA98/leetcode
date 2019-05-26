/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    // Seems easy to me, traverse every node, then make its 
    // left node to point its right?
    // Each node is traversed, the running time is O(n)
    // I just figured out my attempt is not valid 
    // Still valid, recursion appoarch is fine
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    private void helper(Node root){
        if (root == null){
            return;
        }
        
        if (root.left != null && root.right != null){
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null){
            if (root.next.left != null){
                root.right.next = root.next.left;
            }
        }
        
        helper(root.left);
        helper(root.right);
    }
}

// Super happy! One shot, bug-free!!!
// Probably it is a easy medium or I am better!
// I chose to beilieve the latter one!!!
