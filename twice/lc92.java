// standard one pass soln
// 仔细点哦
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        
        for(int i = 0; i < m - 1; i ++){
            left = left.next;
        }
        
        ListNode prev = left.next;
        ListNode next = null;
        ListNode curr = prev.next;
        
        for(int i = 0; i < n - m; i ++){
            next = curr.next;
            curr.next = left.next;
            left.next = curr;
            prev.next = next;
            curr = next;
        }
        
        
        return dummy.next;
    }
}

// Technically two pass but good idea tho
class Solution {
    ListNode left;
    boolean stop = false;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode left1 = head;
        for(int i = 1; i < m; i ++){
            left1 = left1.next;
        }
        this.left = left1;
        swap(left1, n - m);
        
        return head;
    }
    
    private void swap(ListNode head, int distance){
        if(distance > 0){
            swap(head.next, distance - 1);
        }
        
        if(head == left || head.next == left){
            stop = true;
        }
        
        if(!stop){
            int temp = head.val;
            head.val = left.val;
            left.val = temp;
            left = left.next;
        }
    }
}

// violate the restriction of one-pass but o=bug-free tho
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode right = head;
        ListNode temp = new ListNode(0);
        ListNode rightPrev = null;
        temp.next = head;
        ListNode left = temp;
        
        for(int i = 1; i < m; i ++){
            left = left.next;
        }
        
        for(int i = 0; i < n; i ++){
            rightPrev = right;
            right = right.next;
        }
        
        if(right == null){
            left.next = reverse(left.next);
            return temp.next;
        }
        rightPrev.next = null;
        left.next = reverse(left.next);
        ListNode trav = left;
        while(trav.next != null){
            trav = trav.next;
        }
        
        trav.next = right;
        return temp.next;
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}