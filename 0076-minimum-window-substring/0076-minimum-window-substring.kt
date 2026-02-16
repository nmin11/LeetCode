class Solution {
    fun minWindow(s: String, t: String): String {
        val need = mutableMapOf<Char, Int>()
        val window = mutableMapOf<Char, Int>()

        for (c in t) {
            need[c] = need.getOrDefault(c, 0) + 1
        }

        var formed = 0
        val required = need.size
        var left = 0
        var right = 0
        var minLen = Int.MAX_VALUE
        var minLeft = 0

        while (right < s.length) {
            val c = s[right]
            window[c] = window.getOrDefault(c, 0) + 1

            if (need.containsKey(c) && window[c] == need[c]) {
                formed++
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1
                    minLeft = left
                }

                val leftChar = s[left]
                window[leftChar] = window.getOrDefault(leftChar, 0) - 1

                if (need.containsKey(leftChar) && window[leftChar]!! < need[leftChar]!!) {
                    formed--
                }

                left++
            }

            right++
        }

        return if (minLen == Int.MAX_VALUE) "" else s.substring(minLeft, minLeft + minLen)
    }
}