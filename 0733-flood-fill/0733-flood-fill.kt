class Solution {
    private fun dfs(image: Array<IntArray>, row: Int, col: Int, from: Int, to: Int) {
        if (row !in image.indices || col !in image[0].indices) {
            return
        }

        if (image[row][col] != from) return

        image[row][col] = to

        dfs(image, row - 1, col, from, to)
        dfs(image, row + 1, col, from, to)
        dfs(image, row, col - 1, from, to)
        dfs(image, row, col + 1, from, to)
    }

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val from = image[sr][sc]

        if (from == color) return image

        dfs(image, sr, sc, from, color)

        return image
    }
}