class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairIdx = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            if (pairIdx.containsKey(target - num)) {
                return intArrayOf(pairIdx[target - num] ?: 0, i)
            }
            pairIdx[num] = i
        }

        return intArrayOf()
    }
}