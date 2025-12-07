class Solution {
    private lateinit var parent: IntArray

    private fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    private fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            parent[rootY] = rootX
        }
    }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        parent = IntArray(n) { it }

        isConnected.forEachIndexed { i, connections ->
            connections.forEachIndexed { j, connected ->
                if (i < j && connected == 1) {
                    union(i, j)
                }
            }
        }

        return parent.indices.count { find(it) == it }
    }
}