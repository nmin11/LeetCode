class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val tail = mutableListOf<Int>()

        for (num in nums) {
            val pos = binarySearch(tail, num)

            if (pos == tail.size) {
                tail.add(num)
            } else {
                tail[pos] = num
            }
        }

        return tail.size
    }

    private fun binarySearch(list: MutableList<Int>, num: Int): Int {
        var low = 0
        var high = list.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2

            when {
                list[mid] == num -> return mid
                list[mid] < num -> low = mid + 1
                else -> high = mid - 1
            }
        }

        return low
    }
}