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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        return merge(lists, 0, lists.lastIndex)
    }

    private fun merge(lists: Array<ListNode?>, start: Int, end: Int): ListNode? {
        if (start > end) return null
        if (start == end) return lists[start]

        val mid = start + (end - start) / 2

        return mergeTwoLists(
            merge(lists, start, mid),
            merge(lists, mid + 1, end)
        )
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        val dummy = ListNode(0)
        var cur = dummy
        var (left, right) = l1 to l2

        while (left != null && right != null) {
            if (left.`val` < right.`val`) {
                cur.next = left
                left = left.next
            } else {
                cur.next = right
                right = right.next
            }

            cur = cur.next!!
        }

        cur.next = left ?: right

        return dummy.next
    }
}