# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        if head == None:
            return None
        elif head.next == None:
            return head
        
        p1 = head
        p2 = head.next
        p3 = head.next.next
        
        p1.next = p3
        p2.next = p1 
        head = p2
        p0 = p2
        p2 = p3
        if (p3 != None):
            p3 = p3.next
        else:
            return head
        
        proceeding = 1
        while p3 != None:
            p0 = p0.next
            p1 = p1.next
            p2 = p2.next
            p3 = p3.next
            proceeding = proceeding + 1
            if (proceeding == 2):
                proceeding = 0
                p0.next = p2
                p1.next = p3
                p2.next = p1
                dummy = p1
                p1 = p2
                p2 = dummy
                
        return head





class Solution(object):
def swapPairs(self, head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    if not head or not head.next:return head
    p,q=head,head.next
    r=q#r是新的头结点
    while p and q:
        k=p#
        p.next=q.next
        q.next=p
        if p.next and p.next.next:
            p=p.next
            q=p.next
            k.next=q
        else:
            break
    return r

