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

    fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        parent = IntArray(n + 1) { it }
        val inDegree = IntArray(n + 1) { -1 }

        var candidate1: IntArray? = null
        var candidate2: IntArray? = null

        for (i in edges.indices) {
            val (u, v) = edges[i]

            if (inDegree[v] != -1) {
                candidate1 = edges[inDegree[v]]
                candidate2 = edges[i]
                break
            }

            inDegree[v] = i
        }

        for (edge in edges) {
            if (candidate2 != null && edge == candidate2) continue

            val (u, v) = edge

            if (find(u) == find(v)) {
                return candidate1 ?: edge
            }

            union(u, v)
        }

        return candidate2!!
    }
}