class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int freqA = freq.get(a);
            int freqB = freq.get(b);

            if (freqA != freqB) {
                return freqA - freqB;
            }

            return b.compareTo(a);
        });

        for (String word : freq.keySet()) {
            minHeap.add(word);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        LinkedList<String> result = new LinkedList<>();

        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }

        return result;
    }
}