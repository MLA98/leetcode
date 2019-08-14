// O(n) recursion
// DFS, cuz the tree is perfect,
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
        
        if (root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }
        
        helper(root.left);
        helper(root.right);
    }
}

// O(n); O(n) soln
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int p1 = 0;
        while(p1 < s.length() && p1 < t.length()){
            char ch1 = s.charAt(p1);
            char ch2 = t.charAt(p1);
            
            if(ch1 != ch2){
                if(s.length() == t.length()){
                    return s.substring(p1 + 1, s.length()).
                        equals(t.substring(p1 + 1, t.length()));
                }
                else if(s.length() == t.length() + 1){
                    return s.substring(p1 + 1, s.length()).
                        equals(t.substring(p1, t.length()));
                }
                else if(s.length() + 1 == t.length()){
                    return s.substring(p1, s.length()).
                        equals(t.substring(p1 + 1, t.length()));
                }
                else{
                    return false;
                }
            }
                
            p1 ++;
        }
        
        return Math.abs(t.length() - s.length()) == 1;
    }
}