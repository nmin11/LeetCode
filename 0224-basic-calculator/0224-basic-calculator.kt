class Solution {
    fun calculate(s: String): Int {
        var result = 0
        var sign = 1
        var num = 0
        val stack = ArrayDeque<Int>()

        for (c in s) {
            when (c) {
                in '0'..'9' -> {
                    num = num * 10 + (c - '0')
                }
                '+' -> {
                    result += num * sign
                    num = 0
                    sign = 1
                }
                '-' -> {
                    result += num * sign
                    num = 0
                    sign = -1
                }
                '(' -> {
                    stack.addLast(result)
                    stack.addLast(sign)
                    result = 0
                    sign = 1
                }
                ')' -> {
                    result += num * sign
                    num = 0
                    val prevSign = stack.removeLast()
                    val prevResult = stack.removeLast()
                    result = prevResult + prevSign * result
                }
            }
        }

        result += num * sign

        return result
    }
}