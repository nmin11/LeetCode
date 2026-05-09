class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = mutableMapOf(0 to 1)
        var curSum = 0
        var cnt = 0

        for (num in nums) {
            curSum += num
            cnt += map.getOrDefault(curSum - k, 0)
            map[curSum] = map.getOrDefault(curSum, 0) + 1
        }

        return cnt
    }
}