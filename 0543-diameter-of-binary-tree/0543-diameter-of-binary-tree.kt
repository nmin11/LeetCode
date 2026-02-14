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
    private var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return diameter
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val left = dfs(node.left)
        val right = dfs(node.right)

        diameter = maxOf(diameter, left + right)

        return maxOf(left, right) + 1
    }
}