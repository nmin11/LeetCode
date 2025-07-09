class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairIdx = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            val complement = target - num
            if (complement in pairIdx) {
                return intArrayOf(i, pairIdx[complement]!!)
            }
            pairIdx[num] = i
        }

        return intArrayOf()
    }
}