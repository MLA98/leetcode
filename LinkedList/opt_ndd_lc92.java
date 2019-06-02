/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean stop;
    private ListNode left;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        stop = false;
        bthelper(head, m, n);
        return head;
    }
    
    private void bthelper(ListNode right, int m, int n){
        if (n == 1){
            return;
        }
        
        right = right.next;
        
        if (m > 1){
            this.left = this.left.next;
        }
        
        bthelper(right, m - 1, n - 1);
        
        if (this.left == right || this.left == right.next){
            stop = true;
        }
        
        if (!stop){
            int t = right.val;
            right.val = this.left.val;
            this.left.val = t;
            this.left = this.left.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    }
}
