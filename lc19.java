 // two pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode ret = head;
        
        while(head != null){
            length ++;
            head = head.next;
        }
        
        head = ret;
        if((length - n) == 0){
            return ret.next;
        }
        
        ListNode prev = null;
        for(int i = 0; i < length - n; i ++){
            prev = head;
            head = head.next;
        }
        
        prev.next = head.next;
        return ret;
    }
}

// One pass
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        for(int i = 0; i < n; i ++){
            fast = fast.next;
        }
        
        ListNode prev = null;
        while(fast != null){
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        
        prev.next = slow.next;
        return dummy.next;
    }
}

// One pass
