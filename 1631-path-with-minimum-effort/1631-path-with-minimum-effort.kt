import kotlin.math.abs

class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val rows = heights.size
        val cols = heights[0].size
        val directions = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )
        val distance = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }
        distance[0][0] = 0

        val pq = PriorityQueue<IntArray>(compareBy { it[0] })
        pq.offer(intArrayOf(0, 0, 0))
        while (pq.isNotEmpty()) {
            val (effort, row, col) = pq.poll()

            if (row == rows - 1 && col == cols - 1) return effort

            if (effort > distance[row][col]) continue

            for ((dr, dc) in directions) {
                val newRow = row + dr
                val newCol = col + dc

                if (newRow !in 0 until rows || newCol !in 0 until cols) continue

                val heightDiff = abs(heights[newRow][newCol] - heights[row][col])
                val newEffort = maxOf(effort, heightDiff)

                if (newEffort < distance[newRow][newCol]) {
                    distance[newRow][newCol] = newEffort
                    pq.offer(intArrayOf(newEffort, newRow, newCol))
                }
            }
        }

        return 0
    }
}