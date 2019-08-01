class Solution {
    public ListNode partition(ListNode head, int x) {        
        ListNode smallHead = new ListNode(0);
        ListNode dummy = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode dummy2 = bigHead;
        
        while(head != null){
            if(head.val < x){
                smallHead.next = head;
                smallHead = smallHead.next;
            }
            else{
                bigHead.next = head;
                bigHead = bigHead.next;
            }
            
            head = head.next;
        }
        
        bigHead.next = null;
        smallHead.next = dummy2.next;
        return dummy.next;
    }
}