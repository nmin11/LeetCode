class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Len = s1.length
        val s2Len = s2.length

        if (s1Len > s2Len) return false

        val s1Count = IntArray(26)
        val windowCount = IntArray(26)

        for (i in s1.indices) {
            s1Count[s1[i] - 'a']++
            windowCount[s2[i] - 'a']++
        }

        if (s1Count.contentEquals(windowCount)) return true

        for (i in s1Len until s2Len) {
            windowCount[s2[i] - 'a']++
            windowCount[s2[i - s1Len] - 'a']--

            if (s1Count.contentEquals(windowCount)) return true
        }

        return false
    }
}