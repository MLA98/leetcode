class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small_head = new ListNode(0);
        ListNode large_head = new ListNode(0);
        ListNode small = small_head;
        ListNode large = large_head;
        
        while(head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        
        large.next = null;
        small.next = large_head.next;
        return small_head.next;
    }
}

// Basically, when we try to change the link before nodes we have not met. We wont mess up the nodes after. 
// Two points could be used to trace large and small nodes.
// in place 
