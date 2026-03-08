class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n <= 2) return (0 until n).toList()

        val graph = MutableList(n) { mutableSetOf<Int>() }

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        val leaves = ArrayDeque<Int>()
        for (i in graph.indices) {
            if (graph[i].size == 1) {
                leaves.add(i)
            }
        }

        var remainingNodes = n

        while (remainingNodes > 2) {
            val levelSize = leaves.size
            remainingNodes -= levelSize

            repeat(levelSize) {
                val leaf = leaves.removeFirst()

                for (neighbor in graph[leaf]) {
                    graph[neighbor].remove(leaf)

                    if (graph[neighbor].size == 1) {
                        leaves.add(neighbor)
                    }
                }

                graph[leaf].clear()
            }
        }

        return leaves.toList()
    }
}
