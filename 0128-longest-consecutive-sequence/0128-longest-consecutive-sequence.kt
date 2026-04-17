class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        
        var maxLen = 0
        for (num in set) {
            if (num - 1 in set) {
                continue
            }

            var len = 1
            var cur = num
            while (cur + 1 in set) {
                len++
                cur++
            }

            maxLen = maxOf(maxLen, len)
        }

        return maxLen
    }
}