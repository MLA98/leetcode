/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value1 = 0;
        int value2 = 0;
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode traverse = ans;
        while(l1 != null || l2 != null){
            value1 = l1 == null? 0: l1.val;
            value2 = l2 == null? 0: l2.val;
            int sum = carry + value2 + value1;
            if(sum >= 10){
                traverse.next = new ListNode(sum - 10);
                carry = 1;
            }
            else{
                traverse.next = new ListNode(sum);
                carry = 0;
            }
            traverse = traverse.next;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }
        if(carry == 1){
            traverse.next = new ListNode(1);
        }
        return ans.next;
    }
}