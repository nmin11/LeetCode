class Solution {
    fun lengthOfLastWord(s: String): Int {
        var end = s.length - 1
        
        while (end >= 0 && s[end] == ' ') end--

        var wordLength = 0
        while (end >= 0 && s[end] != ' ') {
            wordLength++
            end--
        }

        return wordLength
    }
}