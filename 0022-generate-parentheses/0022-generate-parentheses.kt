class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun dfs(open: Int, close: Int, cur: String) {
            if (open == 0 && close == 0) {
                result.add(cur)
                return
            }
            if (open > 0) dfs(open - 1, close, "$cur(")
            if (close > open) dfs(open, close - 1, "$cur)")
        }

        dfs(n, n, "")

        return result
    }
}