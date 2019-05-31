/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // With hash, two pass solution. Super slow
//     public ListNode deleteDuplicates(ListNode head) {
//         if (head == null){
//             return null;
//         }
//         int currNum = head.val;
//         ListNode travNode = head.next;
//         Set<Integer> set = new HashSet<>();
//         while(travNode != null){
//             if (travNode.val == currNum){
//                 set.add(currNum);
//             }
//             else{
//                 currNum = travNode.val;
//             }
//             travNode = travNode.next;
//         }
        
//         ListNode dummyNode = new ListNode(0);
//         dummyNode.next = head;
//         ListNode dNode = dummyNode;
        
//         while(head != null){
//             if (set.contains(head.val)){
//                 dummyNode.next = head.next;
//                 head = head.next;
//             }
//             else{
//                 head = head.next;
//                 dummyNode = dummyNode.next;
//             }
//         }
//         return dNode.next;
//     }
    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(head.val - 2);
        ListNode mid = new ListNode(head.val - 1);
        ListNode slow = dummy;
        slow.next = mid;
        mid.next = head;
        ListNode fast = head;
        int dupNum = slow.val;
        while(fast != null){
            if (mid.val == fast.val){
                dupNum = fast.val;
                slow.next = fast;
                mid = fast;
                fast = fast.next;
            }
            else if(mid.val == dupNum){
                slow.next = fast;
                mid = fast;
                fast = fast.next;
            }
            else{
                slow = slow.next;
                mid = mid.next;
                fast = fast.next;
            }
        }
        if (mid.val == dupNum){
            slow.next = null;
        }
        return dummy.next.next;
    }
}

// Slow hash two pass versus my triple pointer solution.
// It could be solved by two pointer tho.
