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
    fun insertionSortList(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur = head

        while (cur != null) {
            val next = cur.next
            var prev = dummy

            while (prev.next?.let { it.`val` < cur.`val` } == true) {
                prev = prev.next!!
            }

            cur.next = prev.next
            prev.next = cur

            cur = next
        }

        return dummy.next
    }
}