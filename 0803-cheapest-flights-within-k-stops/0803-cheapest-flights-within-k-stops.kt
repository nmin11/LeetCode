class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        for (flight in flights) {
            graph.putIfAbsent(flight[0], HashMap())
            graph[flight[0]]!![flight[1]] = flight[2]
        }

        val pq: Queue<List<Int>> = PriorityQueue { a: List<Int>, b: List<Int> -> a[1] - b[1] }
        pq.add(listOf(src, 0, 0))

        val visited: MutableMap<Int, Int> = mutableMapOf()

        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            val u = cur[0]
            val uPrice = cur[1]
            var kVisited = cur[2]

            if (u == dst) return uPrice

            visited[u] = kVisited

            if (kVisited <= k) {
                kVisited += 1
                if (graph.containsKey(u)) {
                    for ((key, value) in graph[u]!!) {
                        if (!visited.containsKey(key) || kVisited < visited[key]!!) {
                            val alt = uPrice + value
                            pq.add(listOf(key, alt, kVisited))
                        }
                    }
                }
            }
        }

        return -1
    }
}