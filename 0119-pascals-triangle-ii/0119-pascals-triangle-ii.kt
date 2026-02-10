class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val row = mutableListOf(1)

        for (i in 1..rowIndex) {
            row.add(1)

            for (j in i - 1 downTo 1) {
                row[j] = row[j - 1] + row[j]
            }
        }

        return row
    }
}