/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        
        if(left < right){
            int mid = left + (right - left) / 2;
            ListNode l1 = partition(lists, left, mid);
            ListNode l2 = partition(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);
        }
        
        return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // in-place
        ListNode head = new ListNode(0);
        head.next = l1;
        ListNode prev = head;
        ListNode next = null;
        
        
        while(l1 != null && l2 != null){
            int value1 = l1.val;
            int value2 = l2.val;
            if(value1 > value2){
                next = l2.next;
                prev.next = l2;
                l2.next = l1;
                l2 = next;
                prev = prev.next;
            }
            else{
                prev = l1;
                l1 = l1.next;
            }
        }
        
        if(l1 == null){
            prev.next = l2; 
        }
        
        return head.next;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode ans = lists[0];
        
        for(int i = 1; i < lists.length; i ++){
            ans = mergeTwoLists(ans, lists[i]);
        }
        
        return ans;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // in-place
        ListNode head = new ListNode(0);
        head.next = l1;
        ListNode prev = head;
        ListNode next = null;
        
        
        while(l1 != null && l2 != null){
            int value1 = l1.val;
            int value2 = l2.val;
            if(value1 > value2){
                next = l2.next;
                prev.next = l2;
                l2.next = l1;
                l2 = next;
                prev = prev.next;
            }
            else{
                prev = l1;
                l1 = l1.next;
            }
        }
        
        if(l1 == null){
            prev.next = l2; 
        }
        
        return head.next;
    }
}