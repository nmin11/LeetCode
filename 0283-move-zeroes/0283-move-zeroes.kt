class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var nonZeroIndex = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i]
            }
        }

        nums.fill(0, nonZeroIndex, nums.size)
    }
}