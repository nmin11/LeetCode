class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 1) return listOf(listOf(1))
        if (numRows == 2) return listOf(listOf(1), listOf(1, 1))

        val result = mutableListOf(listOf(1), listOf(1, 1))

        for (i in 3..numRows) {
            val prevRow = result[i - 2]
            val curRow = mutableListOf(1).apply {
                for (j in 1 until i - 1) {
                    add(prevRow[j - 1] + prevRow[j])
                }
                add(1)
            }
            result.add(curRow)
        }

        return result
    }
}