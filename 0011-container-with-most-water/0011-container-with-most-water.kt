class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var curWater = 0
        var mostWater = 0

        while (left < right) {
            curWater = minOf(height[left], height[right]) * (right - left)
            mostWater = maxOf(mostWater, curWater)

            if (height[left] < height[right]) left++
            else right--
        }

        return mostWater
    }
}