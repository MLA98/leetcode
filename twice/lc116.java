

// O(n), O(n) rule violated
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int layer = q.size();
            for(int i = 0; i < layer; i ++){
                Node node = q.poll();
                node.next = i + 1 == layer? null: q.peek();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        
        return root;
    }
}


// O(n) O(n)
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