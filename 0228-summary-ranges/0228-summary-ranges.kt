class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()
        var start = 0
        var end = 0

        while (end < nums.size) {
            while (end + 1 < nums.size && nums[end + 1] == nums[end] + 1) {
                end++
            }

            result.add(
                if (start == end) "${nums[start]}"
                else "${nums[start]}->${nums[end]}"
            )

            end++
            start = end
        }

        return result
    }
}