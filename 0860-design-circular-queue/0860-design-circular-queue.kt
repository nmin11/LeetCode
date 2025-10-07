class MyCircularQueue(k: Int) {
    var queue: IntArray = IntArray(k)
    var front = 0
    var rear = -1
    var len = 0

    fun enQueue(value: Int): Boolean {
        return if (!isFull()) {
            this.rear = (this.rear + 1) % this.queue.size
            this.queue[rear] = value
            this.len++
            true
        } else false
    }

    fun deQueue(): Boolean {
        return if (!isEmpty()) {
            this.front = (this.front + 1) % this.queue.size
            this.len--
            true
        } else false
    }

    fun Front(): Int {
        return if (this.isEmpty()) -1
        else queue[front]
    }

    fun Rear(): Int {
        return if (this.isEmpty()) -1
        else queue[rear]
    }

    fun isEmpty(): Boolean {
        return this.len == 0
    }

    fun isFull(): Boolean {
        return this.len == this.queue.size
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */