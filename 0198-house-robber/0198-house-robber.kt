class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for (i in 2..dp.lastIndex) {
            dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
        }

        return dp.last()
    }
}