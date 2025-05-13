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
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        ListNode firstK = head;
        for (int i = 1; i < k; i++) {
            firstK = firstK.next;
        }

        ListNode secondK = head;
        for (int i = 1; i < length - k + 1; i++) {
            secondK = secondK.next;
        }

        int temp = firstK.val;
        firstK.val = secondK.val;
        secondK.val = temp;

        return head;
    }
}