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
    private var count = 0
    private var result = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inorder(root, k)
        return result
    }

    private fun inorder(node: TreeNode?, k: Int) {
        if (node == null || result != -1) return

        inorder(node.left, k)

        count++
        if (count == k) {
            result = node.`val`
            return
        }

        inorder(node.right, k)
    }
}