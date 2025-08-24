class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        if (sentence.length < 26) return false

        val isPangram = BooleanArray(26)
        var cnt = 0

        sentence.forEach { c ->
            val idx = c - 'a'
            if (!isPangram[idx]) {
                isPangram[idx] = true
                if (++cnt == 26) return true
            }
        }

        return false
    }
}