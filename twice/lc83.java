/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode traverse = dummyHead;
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                traverse.next = head.next;
                head = traverse.next;
            }
            else{
                head = head.next;
                traverse = traverse.next;
            }
        }
        
        return dummyHead.next;
    }
}