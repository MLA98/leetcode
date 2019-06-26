/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // go through a. string first and use hashset to store all of them.
    // go through b. string then, check which one is duplicated.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hset = new HashSet<>();
        while(headA != null){
            hset.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if (hset.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
