class Solution {
    private fun getNext(n: Int): Int {
        var sum = 0
        var num = n

        while (num > 0) {
            val digit = num % 10
            sum += digit * digit
            num /= 10
        }

        return sum
    }

    fun isHappy(n: Int): Boolean {
        val seen = mutableSetOf<Int>()
        var cur = n

        while (cur != 1 && cur !in seen) {
            seen.add(cur)
            cur = getNext(cur)
        }

        return cur == 1
    }
}