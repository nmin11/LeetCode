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
    private fun preorder(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) return

        result.add(node.`val`)
        preorder(node.left, result)
        preorder(node.right, result)
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        preorder(root, result)
        return result
    }
}