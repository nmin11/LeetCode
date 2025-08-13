class Solution {
    fun myAtoi(s: String): Int {
        var result = 0
        
        if (s.isEmpty()) return result

        var idx = 0
        val len = s.length
        var isNegative = false

        while (idx < len && s[idx] == ' ') {
            idx++
        }

        if (idx == len) return result

        if (s[idx] == '-' || s[idx] == '+') {
            isNegative = s[idx] == '-'
            idx++
        }

        while (idx < len && s[idx].isDigit()) {
            val digit = s[idx] - '0'

            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && digit > 7)) {
                return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
            }

            result = result * 10 + digit
            idx++
        }

        return if (isNegative) -result else result
    }
}