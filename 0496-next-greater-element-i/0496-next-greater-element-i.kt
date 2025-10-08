class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val map = mutableMapOf<Int, Int>()

        for (num in nums2) {
            while (stack.isNotEmpty() && stack.first() < num) {
                map[stack.removeFirst()] = num
            }

            stack.addFirst(num)
        }

        val result = IntArray(nums1.size)
        for (i in nums1.indices) {
            result[i] = map.getOrDefault(nums1[i], -1)
        }

        return result
    }
}