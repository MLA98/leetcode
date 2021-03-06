/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        
        while(curr != null){
            ListNode p = dummy;
            ListNode next = curr.next;
            if(p.next == null){
                p.next = curr;
                curr.next = null;
                curr = next;
            }
            else{
                while(p.next != null && p.next.val < curr.val){
                    p = p.next;
                }
                
                curr.next = p.next;
                p.next = curr;
                curr = next;
            }
        }
        
        return dummy.next;
    }
}


// 0 - 2 - 4

// It is a lie that you could not leetcode without paper!
//
