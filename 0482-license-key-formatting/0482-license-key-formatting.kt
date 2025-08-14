class Solution {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val validChars = s.filter { it != '-' }.uppercase()

        if (validChars.isEmpty()) return ""

        val chunks = mutableListOf<String>()
        var idx = validChars.length

        while (idx > 0) {
            val start = maxOf(0, idx - k)
            chunks.add(validChars.substring(start, idx))
            idx = start
        }

        return chunks.reversed().joinToString("-")
    }
}