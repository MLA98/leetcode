/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode next = null;
        while(head != null && head.next != null){
            next = head.next;
            prev.next = next;
            head.next = next.next;
            next.next = head;
            prev = head;
            head = head.next;
        }
        
        return dummy.next;
    }
}