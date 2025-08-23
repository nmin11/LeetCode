class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sMap = mutableMapOf<Char, Int>()

        s.forEach { sChar ->
            sMap[sChar] = sMap.getOrDefault(sChar, 0) + 1
        }

        t.forEach { tChar ->
            val cnt = sMap[tChar] ?: return false
            if (cnt == 0) return false
            sMap[tChar] = cnt - 1
        }

        return true
    }
}