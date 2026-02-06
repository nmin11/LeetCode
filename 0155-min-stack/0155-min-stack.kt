class MinStack() {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)

        if (minStack.isEmpty()) {
            minStack.addLast(`val`)
        } else {
            minStack.addLast(minOf(`val`, minStack.last()))
        }
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */