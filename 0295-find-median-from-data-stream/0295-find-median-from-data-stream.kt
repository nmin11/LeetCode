class MedianFinder() {
    private val maxHeap = PriorityQueue<Int>(reverseOrder())
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        maxHeap.offer(num)
        minHeap.offer(maxHeap.poll())

        if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */