/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }        
        Set<ListNode> contains = new HashSet<>();
        ListNode traverseNode = head;
        while (traverseNode != null){
            if (contains.contains(traverseNode)){
                return true;
            }
            else{
                contains.add(traverseNode);
            }
            traverseNode = traverseNode.next;
        }
        return false;
    }
}

// No extra space.
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
