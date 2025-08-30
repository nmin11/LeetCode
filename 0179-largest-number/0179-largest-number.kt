class Solution {
    fun largestNumber(nums: IntArray): String {
        if (nums.size == 1 && nums[0] == 0) return "0"
        
        val result = nums
            .map { it.toString() }
            .sortedWith { a, b -> (b + a).compareTo(a + b) }
            .joinToString("")
        
        return if (result.startsWith("0")) "0" else result
    }
}