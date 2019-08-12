// O(n) O(n) solution with hashmap
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        Node newHead = new Node(0, null, null);
        Node newTraverse = newHead;
        Map<Node, Node> map = new HashMap<>();
        Node traverse = head;
        
        while(traverse != null){
            newTraverse.next = new Node(traverse.val, traverse.next, null);
            map.put(traverse, newTraverse.next);
            newTraverse = newTraverse.next;
            traverse = traverse.next;
        }
        
        traverse = head;
        newTraverse = newHead.next;
        
        while(traverse != null){
            if(traverse.random != null){
                newTraverse.random = map.get(traverse.random);
            }
            traverse = traverse.next;
            newTraverse = newTraverse.next;
        }
        
        return  newHead.next;
    }
}

// O(n) O(1) solution
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
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node iter = head;
        while(iter != null){
            Node copy = new Node(iter.val, iter.next, null);
            iter.next = copy;
            iter = copy.next;
        }
        
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        Node orig = head;
        iter = head.next;
        Node ret = iter;
        while(iter != null && iter.next != null){
            orig.next = orig.next.next;
            iter.next = iter.next.next;
            orig = orig.next;
            iter = iter.next;
        }
        
        orig.next = null;
            
        return ret;
    }
}