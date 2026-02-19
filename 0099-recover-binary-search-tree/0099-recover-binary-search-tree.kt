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
    fun recoverTree(root: TreeNode?): Unit {
        var first: TreeNode? = null
        var second: TreeNode? = null
        var prev: TreeNode? = null
        var cur = root

        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.`val` > cur.`val`) {
                    if (first == null) {
                        first = prev
                    }

                    second = cur
                }

                prev = cur
                cur = cur.right
            } else {
                var predecessor = cur.left
                while (predecessor?.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right
                }

                if (predecessor?.right == null) {
                    predecessor?.right = cur
                    cur = cur.left
                } else {
                    predecessor.right = null
                    if (prev != null && prev.`val` > cur.`val`) {
                        if (first == null) {
                            first = prev
                        }

                        second = cur
                    }

                    prev = cur
                    cur = cur.right
                }
            }
        }

        if (first != null && second != null) {
            first.`val` = second.`val`.also { second.`val` = first.`val` }
        }
    }
}