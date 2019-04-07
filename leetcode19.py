# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        p1 = head
        p2 = head
        for i in range(n + 1):
            if p1 != None:
                p1 = p1.next
            else:
                if i == n:
                    head = head.next
                    return head
                
        while (p1 != None):
            p1 = p1.next
            p2 = p2.next
        
        if p2.next != None:
            p2.next = p2.next.next
        
        return head
            
