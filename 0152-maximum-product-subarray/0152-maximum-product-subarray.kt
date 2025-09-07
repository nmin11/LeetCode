class Solution {
    fun maxProduct(nums: IntArray): Int {
        var maxProduct = nums[0]
        var minProduct = nums[0]
        var result = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] < 0) {
                maxProduct = minProduct.also { minProduct = maxProduct }
            }

            maxProduct = maxOf(nums[i], maxProduct * nums[i])
            minProduct = minOf(nums[i], minProduct * nums[i])

            result = result.coerceAtLeast(maxProduct)
        }

        return result
    }
}