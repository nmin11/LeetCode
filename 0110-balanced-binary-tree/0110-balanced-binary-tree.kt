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
    private fun height(node: TreeNode?): Int {
        if (node == null) return 0

        val left = height(node.left)
        val right = height(node.right)

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1
        }

        return maxOf(left, right) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) != -1
    }
}