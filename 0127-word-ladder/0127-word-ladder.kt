class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (endWord !in wordList) return 0

        val wordSet = wordList.toSet()
        val visited = mutableSetOf<String>()
        val queue = ArrayDeque<Pair<String, Int>>()
        
        visited.add(beginWord)
        queue.add(beginWord to 1)

        while (queue.isNotEmpty()) {
            val (word, step) = queue.removeFirst()

            if (word == endWord) return step

            for (i in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = buildString {
                        append(word.substring(0, i))
                        append(c)
                        append(word.substring(i + 1))
                    }

                    if (newWord in wordSet && newWord !in visited) {
                        visited.add(newWord)
                        queue.add(newWord to step + 1)
                    }
                }
            }
        }

        return 0
    }
}