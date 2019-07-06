/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null){
            slow.val = fast.val;
            if(fast.next == null){
                slow.next = null;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}