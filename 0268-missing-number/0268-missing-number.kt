class Solution {
    fun missingNumber(nums: IntArray): Int {
        var num = nums.size
        for (i in nums.indices) {
            num = num xor i xor nums[i]
        }

        return num
    }
}