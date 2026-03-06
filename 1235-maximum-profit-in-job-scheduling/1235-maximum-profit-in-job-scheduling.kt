class Solution {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        data class Job(val start: Int, val end: Int, val profit: Int)

        val jobs = startTime.indices
            .map { Job(startTime[it], endTime[it], profit[it]) }
            .sortedBy { it.end }
        
        val dp = TreeMap<Int, Int>()
        dp[0] = 0

        for (job in jobs) {
            val prevMaxProfit = dp.floorEntry(job.start)?.value ?: 0
            val newProfit = prevMaxProfit + job.profit

            if (newProfit > (dp.lastEntry()?.value ?: 0)) {
                dp[job.end] = newProfit
            }
        }

        return dp.lastEntry()?.value ?: 0
    }
}