class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode traverse = dummyHead;
        Integer dup = null;
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                traverse.next = head.next;
                head = traverse.next;
                dup = head.val;
            }
            else if(dup != null && dup == head.val){
                traverse.next = head.next;
                head = traverse.next;
            }
            else{
                head = head.next;
                traverse = traverse.next;
            }
        }
        
        return dummyHead.next;
    }
}