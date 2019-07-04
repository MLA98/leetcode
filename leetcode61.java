/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        int length = 0;
        ListNode stop = head;
        ListNode aheadStop = head;
        ListNode realHead = head;
        while (aheadStop != null){
            length ++;
            aheadStop = aheadStop.next;
            if (length == k){
                break;
            }
        }
        
        if (length < k || aheadStop == null){
            k = k % length;
            if (k == 0){
                return head;
            }
            aheadStop = head;
            length = 0;
            while (aheadStop != null){
                length ++;
                aheadStop = aheadStop.next;
                if (length == k){
                    break;
                }
            }
        }
        while (aheadStop.next != null){
            aheadStop = aheadStop.next;
            stop = stop.next;
        }
        
        ListNode retHead = stop.next;
        stop.next = null;
        aheadStop.next = head;
        return retHead;

    }
}

// Be extremely careful about pointer null!!! Easy in concept (two poninters) but u have to make sure your program does not access some null values!

// Connect the tail and the head;
// Cut where you need
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode head2 = head;
        ListNode prev = null;
        int count = 0;
        
        while(head2 != null){
            count ++;
            prev = head2;
            head2 = head2.next;
        }
        
        k = k % count;
        if(k == 0){
            return head;
        }
        prev.next = head;
        prev = null;
        head2 = head;
        for(int i = 0; i < count - k; i ++){
            prev = head2;
            head2 = head2.next;
        }
        prev.next = null;
        return head2;
    }
}
