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
    private fun merge(left: ListNode?, right: ListNode?): ListNode? {
        left ?: return right
        right ?: return left

        return when {
            left.`val` < right.`val` -> left.apply {
                next = merge(next, right)
            }
            else -> right.apply {
                next = merge(left, next)
            }
        }
    }

    fun sortList(head: ListNode?): ListNode? {
        head?.next ?: return head

        var slow = head
        var fast = head.next

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        val mid = slow?.next
        slow?.next = null

        return merge(sortList(head), sortList(mid))
    }
}