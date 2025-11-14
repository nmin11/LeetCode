class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int u = cur.get(0);
            int uPrice = cur.get(1);
            int kVisited = cur.get(2);

            if (u == dst) return uPrice;

            visited.put(u, kVisited);

            if (kVisited <= k) {
                kVisited += 1;
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        if (!visited.containsKey(v.getKey()) || kVisited < visited.get(v.getKey())) {
                            int alt = uPrice + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, kVisited));
                        }
                    }
                }
            }
        }

        return -1;
    }
}