class MyQueue() {
    val queue: ArrayDeque<Int> = ArrayDeque()

    fun push(x: Int) {
        queue.addLast(x)
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun peek(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */