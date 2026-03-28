class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freq = mutableMapOf<String, Int>()
        for (word in words) {
            freq[word] = freq.getOrDefault(word, 0) + 1
        }

        val minHeap = PriorityQueue<String> { a, b ->
            val freqDiff = freq[a]!! - freq[b]!!
            if (freqDiff != 0) freqDiff else b.compareTo(a)
        }

        for (word in freq.keys) {
            minHeap.add(word)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        val result = LinkedList<String>()
        while (minHeap.isNotEmpty()) {
            result.addFirst(minHeap.poll())
        }

        return result
    }
}