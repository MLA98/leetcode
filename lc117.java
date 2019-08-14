class Solution {
    public Node connect(Node root) {
        Node rootSaved = root;
        // GREAT METHOD
        while(root != null){
            Node dummy = new Node(0, null, null, null);
            Node trav = dummy;
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
            root = dummy.next;
        }
        return rootSaved;
    }
}

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