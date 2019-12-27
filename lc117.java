/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node savedRoot = root;
        while(root != null){
            Node trav = new Node(0, null, null, null);
            Node storedTrav = trav;
            while(root != null){
                if(root.left != null){
                    trav.next = root.left;
                    trav = trav.next;
                }

                if(root.right != null){
                    trav.next = root.right;
                    trav = trav.next;
                }
                root = root.next;
            }
            
            root = storedTrav.next;
        }
        
        return savedRoot;
    }
}