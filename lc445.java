/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = null;
        ListNode next = null;
        while(l1 != null){
            next = l1.next;
            l1.next = prev;
            prev = l1;
            l1 = next;
        }
        
        l1 = prev;
        
        prev = null;
        next = null;
        while(l2 != null){
            next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }
        
        
        l2 = prev;
        int value1 = 0;
        int value2 = 0;
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode traverse = ans;
        while(l1 != null || l2 != null){
            value1 = l1 == null? 0: l1.val;
            value2 = l2 == null? 0: l2.val;
            int sum = carry + value2 + value1;
            if(sum >= 10){
                traverse.next = new ListNode(sum - 10);
                carry = 1;
            }
            else{
                traverse.next = new ListNode(sum);
                carry = 0;
            }
            traverse = traverse.next;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }
        if(carry == 1){
            traverse.next = new ListNode(1);
        }
        
        prev = null;
        next = null;
        l2 = ans.next;
        ans.next = null;
        while(l2 != null){
            next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }
        
        return prev;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode ansk = new ListNode(0);
        ListNode ans = ansk;
        int carry = 0;
        while(!stack1.empty() || !stack2.empty()){
            int val1 =  stack1.empty()? 0: stack1.pop();
            int val2 =  stack2.empty()? 0: stack2.pop();
            // System.out.println(val2);
            int sum = val1 + val2 + carry;
            if(sum >= 10){
                carry = 1;
                sum -= 10;
            }
            else{
                carry = 0;
            }
            
            ans.next = new ListNode(sum);
            ans = ans.next;
        }
        
        if(carry == 1){
            ans.next = new ListNode(1);
            ans = ans.next;
        }
        
        ListNode prev = null;
        ListNode next = null;
        l2 = ansk.next;
        ans.next = null;
        ans.next = null;
        while(l2 != null){
            next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }
        
        return prev;
    }
}