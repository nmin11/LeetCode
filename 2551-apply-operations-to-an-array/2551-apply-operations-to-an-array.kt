class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
        }

        var nonZeroIndex = 0
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i]
            }
        }

        nums.fill(0, nonZeroIndex, nums.size)

        return nums
    }
}