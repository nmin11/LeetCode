class Solution {
    private fun reverseCharArray(chars: CharArray, start: Int, end: Int) {
        var left = start
        var right = end

        while (left < right) {
            val tmp = chars[left]
            chars[left] = chars[right]
            chars[right] = tmp
            left++
            right--
        }
    }

    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        val n = chars.size
        var start = 0

        for (i in 0..n) {
            if (i == n || chars[i] == ' ') {
                reverseCharArray(chars, start, i - 1)
                start = i + 1
            }
        }

        return String(chars)
    }
}