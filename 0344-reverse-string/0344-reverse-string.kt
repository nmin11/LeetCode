class Solution {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.size - 1

        while (start < end) {
            s[start] = s[end].also { s[end] = s[start] }

            start++
            end--
        }
    }
}