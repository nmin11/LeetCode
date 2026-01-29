class Solution {
    fun mySqrt(x: Int): Int {
        if (x < 2) return x

        var left = 1
        var right = x / 2

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                mid == x / mid -> return mid
                mid > x / mid -> right = mid - 1
                else -> left = mid + 1
            }
        }

        return right
    }
}