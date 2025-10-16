class Solution {
    fun scoreOfParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        stack.addLast(0)

        for (c in s) {
            when (c) {
                '(' -> stack.addLast(0)
                ')' -> {
                    val cur = stack.removeLast()
                    val score  = if (cur == 0) 1 else cur * 2
                    stack.addLast(stack.removeLast() + score)
                }
            }
        }

        return stack.last()
    }
}