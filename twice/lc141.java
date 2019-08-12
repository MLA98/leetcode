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
        if(head == null){
            return false;
        }
        
        Set<ListNode> set = new HashSet<>();
        
        while(head != null){
            System.out.println(head);
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        
        return false;
    }
}

// No extra space.
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow, fast;
        slow = fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        
        return false;
    }
}
