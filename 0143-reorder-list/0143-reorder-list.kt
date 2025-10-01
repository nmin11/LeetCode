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
    fun reorderList(head: ListNode?): Unit {
        head?.next ?: return

        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var second = slow?.next
        slow?.next = null

        var prev: ListNode? = null
        while (second != null) {
            val next = second.next
            second.next = prev
            prev = second
            second = next
        }

        var first = head
        second = prev

        while (second != null) {
            val tmp1 = first?.next
            val tmp2 = second.next

            first?.next = second
            second.next = tmp1

            first = tmp1
            second = tmp2
        }
    }
}