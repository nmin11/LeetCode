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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        var cur = dummy

        while (cur.next != null) {
            when {
                cur.next.`val` == `val` -> cur.next = cur.next.next
                else -> cur = cur.next
            }
        }

        return dummy.next
    }
}