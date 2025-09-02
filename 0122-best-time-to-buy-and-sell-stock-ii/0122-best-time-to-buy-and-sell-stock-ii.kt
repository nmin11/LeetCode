class Solution {
    fun maxProfit(prices: IntArray): Int {
        var totalProfit = 0

        for (i in 1 until prices.size) {
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1]
            }
        }

        return totalProfit
    }
}