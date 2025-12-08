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

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        parent = IntArray(n + 1) { it }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            if (find(u) == find(v)) return edge

            union(u, v)
        }

        return IntArray(0)
    }
}