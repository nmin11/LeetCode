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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        tail.next = head;

        int step = len - k % len - 1;
        ListNode newTail = head;
        for (int i = 0; i < step; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next= null;

        return newHead;
    }
}