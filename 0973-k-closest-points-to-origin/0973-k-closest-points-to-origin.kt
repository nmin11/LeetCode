class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray>(
            compareByDescending { it[0] * it[0] + it[1] * it[1] }
        )

        for (point in points) {
            pq.offer(point)

            if (pq.size > k) {
                pq.poll()
            }
        }

        return pq.toTypedArray()
    }
}