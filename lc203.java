/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Too easy, dude, One shot please. bug free please
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode fast = head;
        ListNode slow = null;
        while(fast != null){
            if (val == fast.val){
                slow.next = fast.next;
                fast = fast.next;
            }
            else{
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}

// EASY BUT BUG FREE!!!