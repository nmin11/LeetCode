class Solution {
    fun reverseStr(s: String, k: Int): String {
        val chars = s.toCharArray()
        var i = 0
        while (i < chars.size) {
            var left = i
            var right = minOf(i + k - 1, chars.size - 1)

            while (left < right) {
                chars[left] = chars[right].also { chars[right] = chars[left] }
                left++
                right--
            }
            
            i += 2 * k
        }

        return String(chars)
    }
}