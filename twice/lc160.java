// O(n) O(n) soln

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // O(n) O(n)
        Set<ListNode> set = new HashSet();
        if(headA == null || headB == null){
            return null;
        }
        
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        
        return null;
    }
}

// Non-concise soln
// but O(n) O(1) anyways
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode longer = headB;
        ListNode shorter = headA;
        int lenA = 0;
        int lenB = 0;
            
        while(headA.next != null){
            headA = headA.next;
            lenA ++;
        }
        
        while(headB.next != null){
            headB = headB.next;
            lenB ++;
        }
        
        if(headA.equals(headB)){
            if(lenA > lenB){
                ListNode temp = longer;
                longer = shorter;
                shorter = temp;
            }
            
            for(int i = 0; i < Math.abs(lenA - lenB); i ++){
                longer = longer.next;
            }
            
            while(!longer.equals(shorter)){
                longer = longer.next;
                shorter = shorter.next;
            }
            
            return longer;
        }
        
        return null;
    }
}


// Optimal
public class Solution {
    // go through a. string first and use hashset to store all of them.
    // go through b. string then, check which one is duplicated.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while(p != null || q != null){
            if (p == q){
                return p;
            }
            p = p == null ? headB: p.next;
            q = q == null ? headA: q.next;
        }
        return null;
    }
}
