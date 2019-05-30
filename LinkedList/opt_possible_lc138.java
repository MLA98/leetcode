/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

// Two-pass solution with hashmap. O(N) O(N)
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        // map the cloned node and the old node.
        Map<Node, Node> map =  new HashMap<>();
        Node traverseNode = head;
        // copy the label first.
        while (traverseNode != null){
            Node cloned = new Node();
            cloned.val = traverseNode.val;
            map.put(traverseNode, cloned);
            traverseNode = traverseNode.next;
        }
        // copy the next and random
        traverseNode = head;
        while (traverseNode != null){
            if (traverseNode.next != null){
                map.get(traverseNode).next = map.get(traverseNode.next); 
            }
            if (traverseNode.random != null){
                map.get(traverseNode).random = map.get(traverseNode.random);
            }
            traverseNode = traverseNode.next;
        }
        
        return map.get(head);
    }
}

// There is a fancy way to do it. Zig-zag way, Don't want to do that right now.
