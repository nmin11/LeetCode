class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        if (s.length < p.length) return result

        val pCount = IntArray(26)
        val windowCount = IntArray(26)

        for (i in p.indices) {
            pCount[p[i] - 'a']++
            windowCount[s[i] - 'a']++
        }

        if (pCount.contentEquals(windowCount)) {
            result.add(0)
        }

        for (i in p.length until s.length) {
            windowCount[s[i] - 'a']++
            windowCount[s[i - p.length] - 'a']--

            if (pCount.contentEquals(windowCount)) {
                result.add(i - p.length + 1)
            }
        }

        return result
    }
}