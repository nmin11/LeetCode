class Solution {
    private inline fun Char.getReverseDegree(): Int = 26 - (this - 'a')

    fun reverseDegree(s: String): Int {
        var result = 0
        s.forEachIndexed { i, c ->
            result += c.getReverseDegree() * (i + 1)
        }

        return result
    }
}