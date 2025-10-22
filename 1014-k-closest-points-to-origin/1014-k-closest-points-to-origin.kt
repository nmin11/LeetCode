class Solution {
    data class Point(var distance: Long, var point: IntArray)

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq: Queue<Point> = PriorityQueue(compareBy { a -> a.distance })

        for (point in points) {
            val distance = point[0].toLong() * point[0] + point[1].toLong() * point[1]
            pq.add(Point(distance, point))
        }

        val results: Array<IntArray> = Array(k) { IntArray(2) { 0 } }
        for (i in 0 until k) {
            results[i] = pq.poll().point
        }

        return results
    }
}