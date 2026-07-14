# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        res = []

        while list1:
            res.append(list1.val)
            list1 = list1.next

        while list2:
            res.append(list2.val)
            list2 = list2.next

        res.sort()

        
        head = ListNode(0)
        curr = head


        for item in res:
            curr.next = ListNode(item)
            curr = curr.next
        
        return head.next
        


        