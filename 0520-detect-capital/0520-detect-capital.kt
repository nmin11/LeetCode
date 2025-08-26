class Solution {
    fun detectCapitalUse(word: String): Boolean {
        val upperCnt = word.count { it.isUpperCase() }
        return upperCnt == 0 ||
               upperCnt == word.length ||
               (upperCnt == 1 && word[0].isUpperCase())
    }
}