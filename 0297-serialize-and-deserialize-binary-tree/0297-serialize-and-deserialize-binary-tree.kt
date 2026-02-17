/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return "null,"

        return buildString {
            append(root.`val`)
            append(",")
            append(serialize(root.left))
            append(serialize(root.right))
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val queue = ArrayDeque(data.split(","))
        return dfs(queue)
    }

    private fun dfs(queue: ArrayDeque<String>): TreeNode? {
        val cur = queue.removeFirst()

        if (cur == "null") return null

        val node = TreeNode(cur.toInt())
        node.left = dfs(queue)
        node.right = dfs(queue)

        return node
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */