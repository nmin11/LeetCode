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

        reverseCharArray(chars, 0, n - 1)

        var wordEnd = 0
        var i = 0
        while (i < n) {
            while (i < n && chars[i] == ' ') i++

            if (i == n) break

            if (wordEnd > 0) chars[wordEnd++] = ' '

            val wordStart = wordEnd

            while (i < n && chars[i] != ' ') {
                chars[wordEnd++] = chars[i++]
            }

            reverseCharArray(chars, wordStart, wordEnd - 1)
        }

        return String(chars, 0, wordEnd)
    }
}