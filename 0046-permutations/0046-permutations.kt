class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(prevElements: MutableList<Int>, elements: List<Int>) {
            if (elements.isEmpty()) {
                results.add(prevElements.stream().collect(Collectors.toList()))
            }

            for (e in elements) {
                val nextElements: MutableList<Int> = ArrayList(elements)
                nextElements.remove(e)
                prevElements.add(e)

                dfs(prevElements, nextElements)
                prevElements.remove(e)
            }
        }

        val list = Arrays.stream(nums).boxed().collect(Collectors.toList())
        dfs(mutableListOf(), list)
        
        return results
    }
}