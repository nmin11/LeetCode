class Solution {
    fun firstUniqChar(s: String): Int {
        val charMap = mutableMapOf<Char, Int>()

        for (c in s) {
            charMap[c] = charMap.getOrDefault(c, 0) + 1
        }

        for (i in s.indices) {
            if (charMap[s[i]] == 1) {
                return i
            }
        }

        return -1
    }
}