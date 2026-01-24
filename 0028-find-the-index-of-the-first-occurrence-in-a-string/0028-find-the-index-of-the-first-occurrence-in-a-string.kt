class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val hLen = haystack.length
        val nLen = needle.length

        if (nLen > hLen) return -1

        for (i in 0..hLen - nLen) {
            var hasFound = true

            for (j in 0 until nLen) {
                if (haystack[i + j] != needle[j]) {
                    hasFound = false
                    break
                }
            }

            if (hasFound) return i
        }

        return -1
    }
}