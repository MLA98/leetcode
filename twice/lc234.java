// sb force O(n) O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        
        ListNode reversed = reverse(head);
        
        while(reversed != null){
            if(reversed.val != head.val){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode next = head;
        ListNode newList = null;
        
        while(next != null){
            ListNode newNode = new ListNode(next.val);
            newNode.next = newList;
            newList = newNode;
            next = next.next;
        }
        
        return newList;
    }
}
// standard approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode trav = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode revSecond = reverse(slow.next);
        while(revSecond != null){
            if(revSecond.val != trav.val){
                return false;
            }
            revSecond = revSecond.next;
            trav = trav.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr.next != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        curr.next = prev;
        
        return curr;
    }
}