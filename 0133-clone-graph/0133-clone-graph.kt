/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    private val visited = HashMap<Node, Node>()

    private fun dfs(node: Node): Node {
        visited[node]?.let { return it }

        val copy = Node(node.`val`)
        visited[node] = copy

        for (neighbor in node.neighbors) {
            neighbor?.let { copy.neighbors.add(dfs(neighbor)) }
        }

        return copy
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        return dfs(node)
    }
}