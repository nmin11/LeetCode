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
    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        maxPathDown(root)
        return maxSum
    }

    private fun maxPathDown(node: TreeNode?): Int {
        if (node == null) return 0

        val left = maxOf(maxPathDown(node.left), 0)
        val right = maxOf(maxPathDown(node.right), 0)
        maxSum = maxOf(maxSum, left + node.`val` + right)

        return node.`val` + maxOf(left, right)
    }
}