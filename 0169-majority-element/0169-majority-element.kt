class Solution {
    fun majorityElement(nums: IntArray): Int {
        var cur = 0
        var cnt = 0

        for (num in nums) {
            if (cnt == 0) {
                cur = num
                cnt++
            } else if (cur == num) {
                cnt++
            } else {
                cnt--
            }
        }

        return cur
    }
}