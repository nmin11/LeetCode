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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val curLevel = mutableListOf<Int>()

            repeat(queue.size) {
                val curNode = queue.removeFirst()
                curLevel.add(curNode.`val`)
                listOfNotNull(curNode.left, curNode.right).forEach { queue.add(it) }
            }

            result.add(curLevel)
        }

        return result
    }
}