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
    fun rightSideView(root: TreeNode?): List<Int> {
        root ?: return emptyList()

        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>().apply { add(root) }

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            repeat(levelSize) { i ->
                val node = queue.removeFirst()

                if (i == levelSize - 1) {
                    result.add(node.`val`)
                }

                listOfNotNull(node.left, node.right).forEach { queue.add(it) }
            }
        }

        return result
    }
}