class LRUCache(private val capacity: Int) {
    private val map = mutableMapOf<Int, Node>()
    private val head = Node()
    private val tail = Node()

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToTail(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        map[key]?.let { node ->
            node.value = value
            moveToTail(node)
            return
        }

        val node = Node(key, value)
        map[key] = node
        addToTail(node)

        if (map.size > capacity) {
            val oldest = head.next!!
            removeNode(oldest)
            map.remove(oldest.key)
        }
    }

    private fun removeNode(node: Node) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }

    private fun addToTail(node: Node) {
        node.prev = tail.prev
        node.next = tail
        tail.prev!!.next = node
        tail.prev = node
    }

    private fun moveToTail(node: Node) {
        removeNode(node)
        addToTail(node)
    }

    private class Node(
        val key: Int = 0,
        var value: Int = 0,
        var prev: Node? = null,
        var next: Node? = null
    )
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */