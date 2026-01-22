class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0

        var count = 0
        var length = 2

        for (i in 2 until nums.size) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                length++
                count += (length - 2)
            } else {
                length = 2
            }
        }

        return count
    }
}