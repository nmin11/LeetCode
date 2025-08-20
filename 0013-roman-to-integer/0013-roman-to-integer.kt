class Solution {
    fun romanToInt(s: String): Int {
        val romanMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var prev = 0
        var result = 0
        for (i in s.length - 1 downTo 0) {
            val cur = romanMap[s[i]]!!

            if (cur < prev) result -= cur
            else result += cur

            prev = cur
        }

        return result
    }
}