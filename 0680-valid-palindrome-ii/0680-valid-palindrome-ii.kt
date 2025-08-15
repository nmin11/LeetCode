class Solution {
    private tailrec fun checkPalindrome(s: String, start: Int, end: Int, hasDeleted: Boolean): Boolean {
        return when {
            start >= end -> true
            s[start] == s[end] -> checkPalindrome(s, start + 1, end - 1, hasDeleted)
            hasDeleted -> false
            else -> checkPalindrome(s, start + 1, end, true) ||
                    checkPalindrome(s, start, end - 1, true)
        }
    }

    fun validPalindrome(s: String): Boolean {
        return checkPalindrome(s, 0, s.lastIndex, false)
    }
}