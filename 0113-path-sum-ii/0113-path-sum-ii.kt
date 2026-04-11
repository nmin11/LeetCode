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
    private val result = mutableListOf<List<Int>>()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        root?.let { dfs(it, mutableListOf<Int>(), 0, targetSum) }
        return result
    }

    private fun dfs(node: TreeNode, curPath: MutableList<Int>, curSum: Int, target: Int) {
        curPath.add(node.`val`)
        val newSum = curSum + node.`val`

        if (node.left == null && node.right == null && newSum == target) {
            result.add(curPath.toList())
        }

        node.left?.let { dfs(it, curPath, newSum, target) }
        node.right?.let { dfs(it, curPath, newSum, target) }

        curPath.removeLast()
    }
}