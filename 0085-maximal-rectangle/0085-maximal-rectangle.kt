class Solution {
    private fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var maxArea = 0

        for (i in heights.indices) {
            while (stack.isNotEmpty() && heights[i] < heights[stack.last()]) {
                val height = heights[stack.removeLast()]
                val width = if (stack.isEmpty()) i else i - stack.last() - 1
                maxArea = maxOf(maxArea, height * width)
            }
            stack.addLast(i)
        }

        while (stack.isNotEmpty()) {
            val height = heights[stack.removeLast()]
            val width = if (stack.isEmpty()) heights.size else heights.size - stack.last() - 1
            maxArea = maxOf(maxArea, height * width)
        }

        return maxArea
    }

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0

        var maxArea = 0
        val heights = IntArray(matrix[0].size)

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                heights[j] = if (matrix[i][j] == '1') heights[j] + 1 else 0
            }
            maxArea = maxOf(maxArea, largestRectangleArea(heights))
        }

        return maxArea
    }
}