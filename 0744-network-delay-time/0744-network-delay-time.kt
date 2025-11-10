import java.util.AbstractMap
import java.util.Collections

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        for (time in times) {
            graph.putIfAbsent(time[0], mutableMapOf())
            graph[time[0]]!![time[1]] = time[2]
        }

        val pq: Queue<Map.Entry<Int, Int>> = PriorityQueue(compareBy { it.value })
        pq.add(AbstractMap.SimpleEntry(k, 0))

        val dist: MutableMap<Int, Int> = mutableMapOf()
        while (pq.isNotEmpty()) {
            val (u, distU) = pq.poll()
            if (!dist.containsKey(u)) {
                dist[u] = distU
                if (graph.containsKey(u)) {
                    for ((v, lengthUV) in graph[u]!!) {
                        val alt = distU + lengthUV
                        pq.add(AbstractMap.SimpleEntry(v, alt))
                    }
                }
            }
        }

        return if (dist.size == n) Collections.max(dist.values)
        else -1
    }
}