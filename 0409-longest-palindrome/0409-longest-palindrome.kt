class Solution {
    fun longestPalindrome(s: String): Int {
        val charCount = IntArray(128)
        s.forEach { charCount[it.toInt()]++ }
        val result = charCount.sumOf { it / 2 * 2 }
        return if (result < s.length) result + 1 else result
    }
}