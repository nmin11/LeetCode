class Solution {
    fun commonChars(words: Array<String>): List<String> {
        val minFreq = IntArray(26)
        for (c in words[0]) {
            minFreq[c - 'a']++
        }

        for (i in 1 until words.size) {
            val freq = IntArray(26)
            for (c in words[i]) {
                freq[c - 'a']++
            }

            for (j in 0..25) {
                minFreq[j] = minOf(minFreq[j], freq[j])
            }
        }

        return buildList {
            for (i in 0..25) {
                repeat(minFreq[i]) {
                    add(('a' + i).toString())
                }
            }
        }
    }
}