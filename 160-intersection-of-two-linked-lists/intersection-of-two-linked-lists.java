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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode freeze = headA;
        ListNode current = headB;

        if(headA == null) return headB;
        if(headB == null) return headA;


        while(freeze != null){
            current = headB;
            while(current != null){
                if(current == freeze) return freeze;
                else current = current.next;

            }
            freeze = freeze.next;
        }
        return null;
    }
}