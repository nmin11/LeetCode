/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var node = root
        val pVal = p?.`val` ?: return null
        val qVal = q?.`val` ?: return null

        while (node != null) {
            val nodeVal = node.`val`

            node = when {
                pVal < nodeVal && qVal < nodeVal -> node.left
                pVal > nodeVal && qVal > nodeVal -> node.right
                else -> return node
            }
        }

        return null
    }
}