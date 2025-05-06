/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        int mx = head.val;

        ListNode current = head;

        while(current != null && current.next != null){
            if(current.next.val < mx){
                current.next = current.next.next;
            }else{
                current = current.next;
                mx = current.val;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!= null){
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }

    
}