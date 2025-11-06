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
    private fun dfs(left: TreeNode?, right: TreeNode?): Boolean {
        return when {
            left == null && right == null -> true
            left == null || right == null -> false
            left.`val` != right.`val` -> false
            else -> dfs(left.left, right.right) && dfs(left.right, right.left)
        }
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        return dfs(root?.left, root?.right)
    }
}