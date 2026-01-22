class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window = mutableSetOf<Int>()
        var left = 0

        for (right in nums.indices) {
            if (nums[right] in window) return true
            
            window.add(nums[right])

            if (right - left >= k) {
                window.remove(nums[left])
                left++
            }
        }

        return false
    }
}