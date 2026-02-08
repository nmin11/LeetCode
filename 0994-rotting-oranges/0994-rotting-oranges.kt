class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var minute = 0
        var freshCount = 0
        val directions = listOf(
            Pair(-1, 0),
            Pair(1, 0),
            Pair(0, -1),
            Pair(0, 1)
        )

        val queue = ArrayDeque<Pair<Int, Int>>()

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                when (grid[i][j]) {
                    2 -> queue.add(Pair(i, j))
                    1 -> freshCount++
                }
            }
        }

        while (queue.isNotEmpty()) {
            var hasRotten = false
            repeat(queue.size) {
                val (row, col) = queue.removeFirst()

                for ((dr, dc) in directions) {
                    val nr = row + dr
                    val nc = col + dc

                    if (nr !in grid.indices || nc !in grid[0].indices) continue

                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2
                        queue.add(Pair(nr, nc))
                        freshCount--
                        hasRotten = true
                    }
                }
            }

            if (hasRotten) minute++
        }

        return if (freshCount > 0) -1 else minute
    }
}