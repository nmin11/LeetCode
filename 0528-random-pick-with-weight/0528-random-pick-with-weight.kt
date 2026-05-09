class Solution(w: IntArray) {
    private val prefixSum = IntArray(w.size)

    init {
        var cur = 0
        for (i in w.indices) {
            cur += w[i]
            prefixSum[i] = cur
        }
    }

    fun pickIndex(): Int {
        val picked = (1..prefixSum.last()).random()
        var left = 0
        var right = prefixSum.size - 1

        while (left < right) {
            val mid = (left + right) / 2
            if (picked > prefixSum[mid]) left = mid + 1
            else right = mid
        }

        return left
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */