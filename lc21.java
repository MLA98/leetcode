/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode traverse = head;
        
        while(l1 != null || l2 != null){
            int value1 = l1 == null? Integer.MAX_VALUE: l1.val;
            int value2 = l2 == null? Integer.MAX_VALUE: l2.val;
            if(value1 > value2){
                traverse.next = new ListNode(value2);
                l2 = l2.next;
            }
            else{
                traverse.next = new ListNode(value1);
                l1 = l1.next;
            }
            
            traverse = traverse.next;
        }
        
        return head.next;
    }
}