class TimeMap() {
    private val map = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) { mutableListOf() }.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val pairs = map[key] ?: return ""
        var left = 0
        var right = pairs.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                pairs[mid].first > timestamp -> right = mid - 1
                pairs[mid].first < timestamp -> left = mid + 1
                else -> return pairs[mid].second
            }
        }

        return if (right < 0) "" else pairs[right].second
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */