class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var count = 1
        var writeIdx = 1

        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) count++
            else count = 1

            if (count <= 2) {
                nums[writeIdx++] = nums[i]
            }
        }

        return writeIdx
    }
}