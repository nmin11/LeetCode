class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (token in tokens) {
            when (token) {
                "+" -> stack.addLast(stack.removeLast() + stack.removeLast())
                "-" -> {
                    val last = stack.removeLast()
                    stack.addLast(stack.removeLast() - last)
                }
                "*" -> stack.addLast(stack.removeLast() * stack.removeLast())
                "/" -> {
                    val last = stack.removeLast()
                    stack.addLast(stack.removeLast() / last)
                }
                else -> stack.addLast(token.toInt())
            }
        }

        return stack.last()
    }
}