class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()

        if (sum % 2 == 1) return false

        val target = sum / 2
        val dp = BooleanArray(target + 1).apply { this[0] = true }

        for (num in nums) {
            for (i in target downTo num) {
                dp[i] = dp[i] || dp[i - num]
            }
        }

        return dp[target]
    }
}