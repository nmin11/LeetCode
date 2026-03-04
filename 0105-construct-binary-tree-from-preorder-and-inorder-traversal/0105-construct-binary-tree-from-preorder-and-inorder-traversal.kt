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
    private lateinit var inorderMap: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorderMap = inorder.mapIndexed { index, value -> value to index }.toMap()

        return build(preorder, inorder, 0, preorder.lastIndex, 0, inorder.lastIndex)
    }

    private fun build(
        preorder: IntArray,
        inorder: IntArray,
        preStart: Int,
        preEnd: Int,
        inStart: Int,
        inEnd: Int
    ): TreeNode? {
        if (preStart > preEnd || inStart > inEnd) return null

        val rootVal = preorder[preStart]
        val root = TreeNode(rootVal)
        val inRootIndex = inorderMap[rootVal]!!
        val leftSize = inRootIndex - inStart

        root.left = build(
            preorder,
            inorder,
            preStart + 1,
            preStart + leftSize,
            inStart,
            inRootIndex - 1
        )

        root.right = build(
            preorder,
            inorder,
            preStart + leftSize + 1,
            preEnd,
            inRootIndex + 1,
            inEnd
        )

        return root
    }
}