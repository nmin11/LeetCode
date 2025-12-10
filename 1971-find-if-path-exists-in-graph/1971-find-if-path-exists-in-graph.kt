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

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        parent = IntArray(n) { it }

        edges.forEach {
            union(it[0], it[1])
        }

        return find(source) == find(destination)
    }
}
