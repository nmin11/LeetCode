class Solution {
    fun singleNumber(nums: IntArray): Int = nums.reduce { acc, num -> acc xor num }
}