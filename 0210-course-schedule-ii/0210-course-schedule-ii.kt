class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = List(numCourses) { mutableListOf<Int>() }
        val indegree = IntArray(numCourses)
        for ((a, b) in prerequisites) {
            graph[b].add(a)
            indegree[a]++
        }

        val queue: Queue<Int> = LinkedList()
        for (i in 0 until numCourses) {
            if (indegree[i] == 0) queue.offer(i)
        }

        val result = IntArray(numCourses)
        var idx = 0
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            result[idx++] = cur

            for (next in graph[cur]) {
                indegree[next]--
                if (indegree[next] == 0) queue.offer(next)
            }
        }

        return if (idx == numCourses) result else intArrayOf()
    }
}