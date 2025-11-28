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
    private fun postorder(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) return

        postorder(node.left, result)
        postorder(node.right, result)
        result.add(node.`val`)
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        postorder(root, result)
        return result
    }
}