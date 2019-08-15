

// Violate the O(1) space restriction but the time comp is O(nlgn)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        prev.next = null;
        
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(slow);
        
        return merge(p1, p2);
    }
    
    private ListNode merge(ListNode p1, ListNode p2){
        ListNode temp = new ListNode(0);
        ListNode ret = temp;
        
        while(p1 != null && p2 != null){
            if(p1.val > p2.val){
                temp.next = p2;
                temp = temp.next;
                p2 = p2.next;
            }
            else{
                temp.next = p1;
                temp = temp.next;
                p1 = p1.next;
            }
        }
        
        if(p1 != null){
            temp.next = p1;
        }
        else{
            temp.next = p2;
        }
        
        return ret.next;
    }
}