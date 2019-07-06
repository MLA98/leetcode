// Okay recursive approach
// goes to the last element and trace head by a class variable
class Solution {
    private ListNode root;
    public boolean isPalindrome(ListNode head) {
        root = head;
        if(head == null){
            return true;
        }
        return _isPalindrome(head);
    }
    
    private boolean _isPalindrome(ListNode head){
        boolean flag = true;
        if(head.next != null){
            flag = _isPalindrome(head.next);
        }
        if(flag && root.val == head.val){
            root = root.next;
            return true;
        }
        return false;
    }
}

// sb force
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        
        while(head != null){
            list.add(head.val);
        }
        int m, n;
        if(list.size() % 2 == 0){
            m = list.size() / 2 - 1;
            n = list.size() / 2; 
        }
        else{
            m = list.size() / 2 - 1;
            n = list.size() / 2 + 1;
        }
        while(m >= 0){
            if(list.get(m) != list.get(n)){
                return false;
            }
            m --;
            n ++;
        }
        return true;
    }
}

// standard approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast, slow, prev;
        prev = null;
        slow = fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null){
            prev.next = reverse(slow);
            prev = prev.next;
        }
        else{
            slow.next = reverse(slow.next);
            prev = slow.next;
        }
        while(prev != null){
            if(prev.val != head.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}