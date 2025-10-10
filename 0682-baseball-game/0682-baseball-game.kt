class Solution {
    fun calPoints(operations: Array<String>): Int {
        var result = 0
        val stack = ArrayDeque<Int>()

        for (op in operations) {
            when (op) {
                "+" -> {
                    val last = stack.removeLast()
                    val sum = last + stack.last()
                    stack.addLast(last)
                    stack.addLast(sum)
                    result += sum
                }
                "D" -> {
                    val score = stack.last() * 2
                    stack.addLast(score)
                    result += score
                }
                "C" -> {
                    result -= stack.removeLast()
                }
                else -> {
                    val num = op.toInt()
                    stack.addLast(num)
                    result += num
                }
            }
        }

        return result
    }
}