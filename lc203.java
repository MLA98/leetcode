class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Easy as fuck
        // If you do it wrong, you are a dumbass then.
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }
            else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}