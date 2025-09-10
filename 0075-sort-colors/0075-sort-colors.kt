class Solution {
    fun sortColors(nums: IntArray): Unit {
        var red = 0
        var white = 0
        var blue = nums.lastIndex

        while (white <= blue) {
            when (nums[white]) {
                0 -> {
                    nums[red] = nums[white].also { nums[white] = nums[red] }
                    red++
                    white++
                }
                1 -> white++
                2 -> {
                    nums[white] = nums[blue].also { nums[blue] = nums[white] }
                    blue--
                }
            }
        }
    }
}