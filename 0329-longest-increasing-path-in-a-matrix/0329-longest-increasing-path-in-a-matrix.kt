class Solution {
    private val dr = intArrayOf(0, 0, 1, -1)
    private val dc = intArrayOf(1, -1, 0, 0)

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val memo = Array(m) { IntArray(n) }

        return (0 until m).maxOf { r ->
            (0 until n).maxOf { c ->
                dfs(r, c, matrix, memo)
            }
        }
    }

    private fun dfs(row: Int, col: Int, matrix: Array<IntArray>, memo: Array<IntArray>): Int {
        if (memo[row][col] != 0) return memo[row][col]

        var max = 0
        for (i in 0 until 4) {
            val nr = row + dr[i]
            val nc = col + dc[i]

            if (nr < 0 ||
                nr >= matrix.size ||
                nc < 0 ||
                nc >= matrix[0].size ||
                matrix[row][col] >= matrix[nr][nc]
            ) continue

            max = maxOf(max, dfs(nr, nc, matrix, memo))
        }

        memo[row][col] = 1 + max

        return memo[row][col]
    }
}