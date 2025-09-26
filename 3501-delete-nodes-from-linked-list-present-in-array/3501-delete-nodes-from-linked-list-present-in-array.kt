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
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val toDelete = nums.toSet()
        val dummy = ListNode(0).apply { next = head }
        var cur = dummy

        while (cur.next != null) {
            if (cur.next.`val` in toDelete) {
                cur.next = cur.next.next
            } else {
                cur = cur.next
            }
        }

        return dummy.next
    }
}