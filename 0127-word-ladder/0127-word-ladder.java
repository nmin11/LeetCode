class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            String word = cur.word;
            int step = cur.step;

            if (word.equals(endWord)) return step;

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();

                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        visited.add(newWord);
                        queue.offer(new Pair(newWord, step + 1));
                    }
                }
            }
        }

        return 0;
    }

    private class Pair {
        String word;
        int step;

        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}