class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(nums.size) { -1 }

        for (i in 0 until nums.size * 2) {
            val num = nums[i % nums.size]

            while (stack.isNotEmpty() && nums[stack.first()] < num) {
                result[stack.removeFirst()] = num
            }

            if (i < nums.size) {
                stack.addFirst(i)
            }
        }

        return result
    }
}