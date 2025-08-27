class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastIdx = mutableMapOf<Char, Int>()
        var left = 0
        var maxLen = 0

        s.forEachIndexed { idx, c ->
            lastIdx[c]?.let { prevIdx ->
                left = maxOf(left, prevIdx + 1)
            }
            lastIdx[c] = idx
            maxLen = maxOf(maxLen, idx - left + 1)
        }

        return maxLen
    }
}