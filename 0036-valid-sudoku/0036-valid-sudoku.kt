class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = List(9) { mutableSetOf<Char>() }
        val cols = List(9) { mutableSetOf<Char>() }
        val boxes = List(9) { mutableSetOf<Char>() }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val c = board[i][j]

                if (c == '.') continue

                val boxIndex = (i / 3) * 3 + (j / 3)

                if (c in rows[i] || c in cols[j] || c in boxes[boxIndex]) {
                    return false
                }

                rows[i].add(c)
                cols[j].add(c)
                boxes[boxIndex].add(c)
            }
        }
        
        return true
    }
}