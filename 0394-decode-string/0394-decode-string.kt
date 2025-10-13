class Solution {
    fun decodeString(s: String): String {
        val countStack = ArrayDeque<Int>()
        val stringStack = ArrayDeque<String>()
        var curNum = 0
        var curStr = ""

        s.forEach { c ->
            when (c) {
                in '0'..'9' -> curNum = curNum * 10 + c.digitToInt()
                '[' -> {
                    countStack.addLast(curNum)
                    stringStack.addLast(curStr)
                    curNum = 0
                    curStr = ""
                }
                ']' -> {
                    val repeatCount = countStack.removeLast()
                    val prevStr = stringStack.removeLast()
                    curStr = prevStr + curStr.repeat(repeatCount)
                }
                else -> curStr += c
            }
        }

        return curStr
    }
}