class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var islands = 0
        var neighbors = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    islands++
                    if (i + 1 < grid.size && grid[i + 1][j] == 1) neighbors++
                    if (j + 1 < grid[0].size && grid[i][j + 1] == 1) neighbors++
                }
            }
        }

        return islands * 4 - neighbors * 2
    }
}