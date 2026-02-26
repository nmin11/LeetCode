class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var num = columnNumber

        return buildString {
            while (num > 0) {
                num--
                append('A' + (num % 26))
                num /= 26
            }
        }.reversed()
    }
}