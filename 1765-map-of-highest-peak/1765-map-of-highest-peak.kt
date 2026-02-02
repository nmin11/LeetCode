class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val m = isWater.size
        val n = isWater[0].size
        
        val queue = ArrayDeque<Pair<Int, Int>>()
        val result = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (isWater[i][j] == 1) {
                    queue.add(i to j)
                    result[i][j] = 0
                } else {
                    result[i][j] = -1
                }
            }
        }
        
        val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        while (queue.isNotEmpty()) {
            val (row, col) = queue.removeFirst()
            
            for ((dr, dc) in dirs) {
                val nr = row + dr
                val nc = col + dc
                
                if (nr in 0 until m &&
                    nc in 0 until n &&
                    result[nr][nc] == -1) {
                    
                    result[nr][nc] = result[row][col] + 1
                    queue.add(nr to nc)
                }
            }
        }
        
        return result
    }
}