class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val a = if (nums1.size <= nums2.size) nums1 else nums2
        val b = if (nums1.size <= nums2.size) nums2 else nums1
        val m = a.size
        val n = b.size
        var left = 0
        var right = m
        var maxLeft1 = Int.MIN_VALUE
        var minRight1 = Int.MAX_VALUE
        var maxLeft2 = Int.MIN_VALUE
        var minRight2 = Int.MAX_VALUE

        while (left <= right) {
            val i = (left + right) / 2
            val j = (m + n + 1) / 2 - i

            maxLeft1 = if (i == 0) Int.MIN_VALUE else a[i - 1]
            minRight1 = if (i == m) Int.MAX_VALUE else a[i]
            maxLeft2 = if (j == 0) Int.MIN_VALUE else b[j - 1]
            minRight2 = if (j == n) Int.MAX_VALUE else b[j]

            when {
                maxLeft1 <= minRight2 && maxLeft2 <= minRight1 -> break
                maxLeft1 > minRight2 -> right = i - 1
                else -> left = i + 1
            }
        }

        val maxLeft = maxOf(maxLeft1, maxLeft2)
        val minRight = minOf(minRight1, minRight2)

        return if ((m + n) % 2 == 1) maxLeft.toDouble()
        else (maxLeft + minRight) / 2.0
    }
}