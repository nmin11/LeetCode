class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0

        for (c in columnTitle) {
            val num = c - 'A' + 1
            result = result * 26 + num
        }

        return result
    }
}