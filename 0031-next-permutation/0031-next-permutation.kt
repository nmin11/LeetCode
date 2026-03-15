class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        val n = nums.size

        var i = n - 2
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }

        if (i < 0) {
            reverse(nums, 0, n - 1)
            return
        }

        var j = n - 1
        while (nums[j] <= nums[i]) {
            j--
        }

        swap(nums, i, j)
        reverse(nums, i + 1, n - 1)
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i] = nums[j].also { nums[j] = nums[i] }
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end

        while (left < right) {
            swap(nums, left, right)
            left++
            right--
        }
    }
}