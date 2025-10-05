class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack: ArrayDeque<Int> = ArrayDeque()
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.first()]) {
                val last = stack.removeFirst()
                result[last] = i - last
            }

            stack.addFirst(i)
        }

        return result
    }
}