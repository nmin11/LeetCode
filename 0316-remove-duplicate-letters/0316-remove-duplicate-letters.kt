class Solution {
    fun removeDuplicateLetters(s: String): String {
        val counter: MutableMap<Char, Int> = HashMap()
        val seen: MutableMap<Char, Boolean> = HashMap()
        val stack: ArrayDeque<Char> = ArrayDeque()

        for (c in s) counter[c] = counter.getOrDefault(c, 0) + 1

        for (c in s) {
            counter[c] = counter[c]!! - 1

            if (seen[c] == true) continue

            while (stack.isNotEmpty() && stack.first() > c && counter[stack.first()]!! > 0) {
                seen[stack.removeFirst()] = false
            }

            stack.addFirst(c)
            seen[c] = true
        }

        return stack.reversed().joinToString("")
    }
}