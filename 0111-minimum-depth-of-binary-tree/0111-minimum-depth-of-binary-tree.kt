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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(root to 1)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.removeFirst()

            if (node.left == null && node.right == null) {
                return depth
            }

            node.left?.let { queue.add(it to depth + 1) }
            node.right?.let { queue.add(it to depth + 1) }
        }

        return 0
    }
}