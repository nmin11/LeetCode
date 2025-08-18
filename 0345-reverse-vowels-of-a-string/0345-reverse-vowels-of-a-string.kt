class Solution {
    private inline fun Char.isVowel(): Boolean {
        return this in "aeiouAEIOU"
    }

    private inline fun CharArray.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }

    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()
        var left = 0
        var right = chars.lastIndex

        while (left < right) {
            val leftIsVowel = chars[left].isVowel()
            val rightIsVowel = chars[right].isVowel()

            when {
                leftIsVowel && rightIsVowel -> {
                    chars.swap(left, right)
                    left++
                    right--
                }
                leftIsVowel -> right--
                rightIsVowel -> left++
                else -> {
                    left++
                    right--
                }
            }
        }

        return String(chars)
    }
}