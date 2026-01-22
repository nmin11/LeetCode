class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (c in s) {
            when (c) {
                '(' -> stack.addLast(')')
                '{' -> stack.addLast('}')
                '[' -> stack.addLast(']')
                else -> {
                    if (stack.isEmpty() || stack.removeLast() != c) return false
                }
            }
        }

        return stack.isEmpty()
    }
}