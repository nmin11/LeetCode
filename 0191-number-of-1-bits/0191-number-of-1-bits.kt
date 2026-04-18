class Solution {
    fun hammingWeight(n: Int): Int {
        var num = n
        var count = 0

        while (num != 0) {
            count++
            num = num and (num - 1)
        }

        return count
    }
}