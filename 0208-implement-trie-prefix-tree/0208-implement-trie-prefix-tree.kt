class Trie() {
    private val root = TrieNode()

    fun insert(word: String) {
        var cur = root

        for (c in word) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = TrieNode()
            }

            cur = cur.children[c - 'a']!!
        }

        cur.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var cur = root

        for (c in word) {
            cur = cur.children[c - 'a'] ?: return false
        }

        return cur.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root

        for (c in prefix) {
            cur = cur.children[c - 'a'] ?: return false
        }

        return true
    }

    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var isEndOfWord = false
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */