/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var walker = head
        var runner = head

        while (runner != null) {
            runner = runner.next

            if (runner != null) {
                runner = runner.next
                walker = walker?.next
            }
        }

        return walker
    }
}