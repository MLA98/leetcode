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
    public ListNode detectCycle(ListNode head) {
        ListNode head2 = head;
        if(head == null){
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        boolean loop = false;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                loop = true;
                break;
            }
        }
                
        
        if(loop){
            while(head2 != fast){
                head2 = head2.next;
                fast = fast.next;
            }
            return head2;
        }
        
        return null;
    }
}