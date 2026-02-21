class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet()
        val dp = BooleanArray(s.length + 1).apply { this[0] = true }

        for (i in 1..s.length) {
            dp[i] = (0 until i).any { j ->
                dp[j] && s.substring(j, i) in wordSet
            }
        }

        return dp[s.length]
    }
}