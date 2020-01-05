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
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        ListNode head = ans;
        
        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            
            head.next = new ListNode(Math.min(val1, val2));
            head = head.next;
            
            if(val1 >= val2) {
                if(val2 != Integer.MAX_VALUE){
                    l2 = l2.next;
                }
            }
            else {
                if(val1 != Integer.MAX_VALUE){
                    l1 = l1.next;
                }
            }
        }
        
        return ans.next;
    }
}