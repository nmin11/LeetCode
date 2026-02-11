class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        backtrack(results, mutableListOf(), nums, BooleanArray(nums.size))
        return results
    }

    private fun backtrack(
        results: MutableList<List<Int>>,
        cur: MutableList<Int>,
        nums: IntArray,
        used: BooleanArray
    ) {
        if (cur.size == nums.size) {
            results.add(cur.toList())
            return
        }

        for (i in nums.indices) {
            if (used[i]) continue

            cur.add(nums[i])
            used[i] = true

            backtrack(results, cur, nums, used)

            cur.removeAt(cur.size - 1)
            used[i] = false
        }
    }
}