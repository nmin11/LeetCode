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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        head ?: return null

        var tail = head
        var len = 1
        while (tail?.next != null) {
            tail = tail.next!!
            len++
        }

        tail.next = head

        val step = len - k % len - 1
        var newTail = head
        repeat(step) {
            newTail = newTail?.next
        }

        val newHead = newTail?.next
        newTail?.next = null

        return newHead
    }
}