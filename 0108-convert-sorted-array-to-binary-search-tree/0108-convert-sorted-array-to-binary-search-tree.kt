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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildBST(nums, 0, nums.size - 1)
    }

    private fun buildBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val mid = start + (end - start) / 2
        return TreeNode(nums[mid]).apply {
            left = buildBST(nums, start, mid - 1)
            right = buildBST(nums, mid + 1, end)
        }
    }
}