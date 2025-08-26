class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        return s in (s + s).drop(1).dropLast(1)
    }
}