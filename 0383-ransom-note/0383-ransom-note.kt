class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val chars = IntArray(26)

        for (c in magazine) {
            chars[c - 'a']++
        }

        for (c in ransomNote) {
            if (chars[c - 'a'] == 0) return false

            chars[c - 'a']--
        }

        return true
    }
}