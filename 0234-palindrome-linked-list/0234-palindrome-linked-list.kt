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
    fun isPalindrome(head: ListNode?): Boolean {
        val deque: Deque<Int> = LinkedList()
        var node = head
        while (node != null) {
            deque.add(node.`val`)
            node = node.next
        }

        while (!deque.isEmpty() && deque.size > 1) {
            if (deque.pollFirst() != deque.pollLast()) return false
        }

        return true
    }
}