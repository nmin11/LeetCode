class WordDictionary() {
    private val root = TrieNode()

    fun addWord(word: String) {
        var cur = root

        for (c in word) {
            val index = c - 'a'

            if (cur.children[index] == null) {
                cur.children[index] = TrieNode()
            }

            cur = cur.children[index]!!
        }

        cur.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return dfs(root, word, 0)
    }

    private fun dfs(node: TrieNode, word: String, index: Int): Boolean {
        if (index == word.length) return node.isEndOfWord

        val c = word[index]

        return if (c == '.') {
            node.children.any { child ->
                child != null && dfs(child, word, index + 1)
            }
        } else {
            val childIndex = c - 'a'
            node.children[childIndex]?.let { dfs(it, word, index + 1) } ?: false
        }
    }

    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var isEndOfWord = false
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */