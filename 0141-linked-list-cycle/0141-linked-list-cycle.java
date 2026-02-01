/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null) {
            runner = runner.next;

            if (runner != null) {
                runner = runner.next;
                walker = walker.next;

                if (runner == walker) break;
            } else {
                break;
            }
        }

        if (runner == null) {
            return false;
        } else {
            return true;
        }
    }
}