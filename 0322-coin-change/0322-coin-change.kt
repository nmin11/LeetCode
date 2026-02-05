class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val max = Int.MAX_VALUE
        val dp = IntArray(amount + 1) { max }
        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i < coin) continue

                if (dp[i - coin] != max) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }

        return if (dp[amount] == max) -1 else dp[amount]
    }
}