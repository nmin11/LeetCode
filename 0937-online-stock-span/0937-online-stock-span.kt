class StockSpanner() {
    private val priceStack = ArrayDeque<Int>()
    private val spanStack = ArrayDeque<Int>()

    fun next(price: Int): Int {
        var span = 1

        while (priceStack.isNotEmpty() && priceStack.last() <= price) {
            priceStack.removeLast()
            span += spanStack.removeLast()
        }
        
        priceStack.addLast(price)
        spanStack.addLast(span)
        
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */