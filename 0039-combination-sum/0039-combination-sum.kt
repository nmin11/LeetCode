class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(target: Int, index: Int, path: ArrayDeque<Int>) {
            if (target < 0) return
            if (target == 0) {
                results.add(ArrayList(path))
                return
            }

            for (i in index until candidates.size) {
                path.add(candidates[i])
                dfs(target - candidates[i], i, path)
                path.removeLast()
            }
        }

        dfs(target, 0, ArrayDeque())

        return results
    }
}