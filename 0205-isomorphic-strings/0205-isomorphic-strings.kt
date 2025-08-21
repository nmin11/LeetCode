class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val ismorphicMap = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            val sChar = s[i]
            val tChar = t[i]

            when {
                ismorphicMap.containsKey(sChar) -> {
                    if (ismorphicMap[sChar] != tChar) return false
                }
                ismorphicMap.containsValue(tChar) -> return false
                else -> ismorphicMap[sChar] = tChar
            }
        }

        return true
    }
}