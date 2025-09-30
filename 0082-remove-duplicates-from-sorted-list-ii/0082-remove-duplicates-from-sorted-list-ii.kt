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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        var cur = dummy

        while (cur.next != null) {
            if (cur.next.next != null && cur.next.`val` == cur.next.next.`val`) {
                val duplicateVal = cur.next.`val`
                while (cur.next != null && cur.next.`val` == duplicateVal) {
                    cur.next = cur.next.next
                }
            } else {
                cur = cur.next
            }
        }

        return dummy.next
    }
}