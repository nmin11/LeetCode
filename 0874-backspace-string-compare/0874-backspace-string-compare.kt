class Solution {
    private fun nextValidIndex(s: String, index: Int): Int {
        var idx = index
        var skip = 0

        while (idx >= 0) {
            when {
                s[idx] == '#' -> {
                    skip++
                    idx--
                }
                skip > 0 -> {
                    skip--
                    idx--
                }
                else -> break
            }
        }

        return idx
    }

    fun backspaceCompare(s: String, t: String): Boolean {
        var i = s.length - 1
        var j = t.length - 1

        while (i >= 0 || j >= 0) {
            i = nextValidIndex(s, i)
            j = nextValidIndex(t, j)

            if (i < 0 && j < 0) return true
            if (i < 0 || j < 0) return false
            if (s[i] != t[j]) return false

            i--
            j--
        }

        return true
    }
}