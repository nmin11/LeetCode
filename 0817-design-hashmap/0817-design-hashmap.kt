class MyHashMap() {
    class Node(var key: Int, var `val`: Int) {
        var next: Node? = null
    }

    val nodes: Array<Node?> = arrayOfNulls(1000000)

    fun put(key: Int, value: Int) {
        val index = key % nodes.size
        if (nodes[index] == null) {
            nodes[index] = Node(key, value)
            return
        }

        var node = nodes[index]
        while (node != null) {
            if (node.key == key) {
                node.`val` = value
                return
            }

            if (node.next == null) break

            node = node.next
        }

        node!!.next = Node(key, value)
    }

    fun get(key: Int): Int {
        val index = key % nodes.size
        if (nodes[index] == null) return -1

        var node = nodes[index]
        while (node != null) {
            if (node.key == key) return node.`val`

            node = node.next
        }

        return -1
    }

    fun remove(key: Int) {
        val index = key % nodes.size
        if (nodes[index] == null) return

        var node = nodes[index]
        if (node!!.key == key) {
            if (node.next == null) nodes[index] = null
            else nodes[index] = node.next
        }

        var prev = node
        while (node != null) {
            if (node.key == key) {
                prev!!.next = node.next
                return
            }

            prev = node
            node = node.next
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */