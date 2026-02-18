class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (dfs(board, word, i, j, 0)) return true
            }
        }

        return false
    }

    private fun dfs(board: Array<CharArray>, word: String, row: Int, col: Int, index: Int): Boolean {
        if (row !in board.indices || col !in board[0].indices) return false
        if (board[row][col] == '#') return false
        if (board[row][col] != word[index]) return false
        if (index == word.lastIndex) return true

        val tmp = board[row][col]
        board[row][col] = '#'

        val found = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1).any { (dr, dc) ->
            dfs(board, word, row + dr, col + dc, index + 1)
        }

        board[row][col] = tmp

        return found
    }
}