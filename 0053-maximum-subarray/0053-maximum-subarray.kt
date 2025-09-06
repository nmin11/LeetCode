class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var curSum = nums[0]
        var maxSum = nums[0]

        for (i in 1 until nums.size) {
            curSum = maxOf(curSum + nums[i], nums[i])
            maxSum = maxOf(maxSum, curSum)
        }

        return maxSum
    }
}