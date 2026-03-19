class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            cur = cur.children[c - 'a'];
        }
        
        cur.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) return node.isEndOfWord;

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null) {
                    if (dfs(child, word, index + 1)) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            if (node.children[c - 'a'] == null) {
                return false;
            }

            return dfs(node.children[c - 'a'], word, index + 1);
        }
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */