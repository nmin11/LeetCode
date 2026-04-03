class FreqStack() {
    private val freqMap = mutableMapOf<Int, Int>()
    private val group = mutableMapOf<Int, ArrayDeque<Int>>()
    private var maxFreq = 0

    fun push(`val`: Int) {
        val updatedFreq = freqMap.getOrDefault(`val`, 0) + 1
        freqMap[`val`] = updatedFreq
        group.getOrPut(updatedFreq) { ArrayDeque() }.add(`val`)
        maxFreq = maxOf(maxFreq, updatedFreq)
    }

    fun pop(): Int {
        val value = group[maxFreq]!!.removeLast()
        freqMap[value] = freqMap[value]!! - 1

        if (group[maxFreq]!!.isEmpty()) {
            maxFreq--
        }

        return value
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(`val`)
 * var param_2 = obj.pop()
 */