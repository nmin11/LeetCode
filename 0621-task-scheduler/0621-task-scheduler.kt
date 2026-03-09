class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val frequency = IntArray(26)
        for (task in tasks) {
            frequency[task - 'A']++
        }

        val maxFrequency = frequency.max()
        val tasksWithMaxFrequency = frequency.count { it == maxFrequency }
        val frameTime = (maxFrequency - 1) * (n + 1) + tasksWithMaxFrequency

        return maxOf(frameTime, tasks.size)
    }
}