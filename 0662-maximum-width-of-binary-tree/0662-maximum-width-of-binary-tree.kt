/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = LinkedList<Pair<TreeNode, Int>>()
        queue.offer(root to 0)

        var maxWidth = 1
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var left = 0
            var right = 0

            for (i in 0 until levelSize) {
                val (node, index) = queue.poll()

                if (i == 0) left = index
                if (i == levelSize - 1) right = index

                node.left?.let {
                    queue.offer(it to 2 * index)
                }
                node.right?.let {
                    queue.offer(it to 2 * index + 1)
                }
            }

            maxWidth = maxOf(maxWidth, right - left + 1)
        }

        return maxWidth
    }
}