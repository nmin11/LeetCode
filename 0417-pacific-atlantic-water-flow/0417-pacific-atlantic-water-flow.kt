class Solution {
    private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size
        val pacificVisited = Array(m) { BooleanArray(n) }
        val atlanticVisited = Array(m) { BooleanArray(n) }

        for (i in 0 until m) {
            dfs(heights, pacificVisited, i, 0)
        }

        for (j in 0 until n) {
            dfs(heights, pacificVisited, 0, j)
        }

        for (i in 0 until m) {
            dfs(heights, atlanticVisited, i, n - 1)
        }

        for (j in 0 until n) {
            dfs(heights, atlanticVisited, m - 1, j)
        }

        return buildList {
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                        add(listOf(i, j))
                    }
                }
            }
        }
    }

    private fun dfs(heights: Array<IntArray>, visited: Array<BooleanArray>, i: Int, j: Int) {
        if (visited[i][j]) return

        visited[i][j] = true

        for ((di, dj) in directions) {
            val newI = i + di
            val newJ = j + dj

            if (newI in 0 until heights.size &&
                newJ in 0 until heights[0].size &&
                heights[newI][newJ] >= heights[i][j]) {
                dfs(heights, visited, newI, newJ)
            }
        }
    }
}