class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val result = Array(mat.size) { IntArray(mat[0].size) }

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    queue.add(i to j)
                    result[i][j] = 0
                } else {
                    result[i][j] = Int.MAX_VALUE
                }
            }
        }

        val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        while (queue.isNotEmpty()) {
            val (row, col) = queue.removeFirst()

            for ((dr, dc) in dirs) {
                val nr = row + dr
                val nc = col + dc

                if (nr in mat.indices &&
                    nc in mat[0].indices &&
                    result[nr][nc] > result[row][col] + 1) {
                    result[nr][nc] = result[row][col] + 1
                    queue.add(nr to nc)
                }
            }
        }

        return result
    }
}