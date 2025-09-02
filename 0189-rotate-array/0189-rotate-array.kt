class Solution {
    private fun IntArray.reverse(start: Int, end: Int) {
        var left = start
        var right = end
        
        while (left < right) {
            this[left] = this[right].also { this[right] = this[left] }
            left++
            right--
        }
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        val kMod = k % nums.size
        if (kMod == 0) return

        nums.reverse(0, nums.size - 1)
        nums.reverse(0, kMod - 1)
        nums.reverse(kMod, nums.size - 1)
    }
}