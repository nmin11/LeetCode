class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        if (n == 2) return Arrays.asList(0, 1);

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {
            int levelSize = leaves.size();
            remainingNodes -= levelSize;

            for (int i = 0; i < levelSize; i++) {
                int leaf = leaves.poll();

                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);

                    if (graph.get(neighbor).size() == 1) {
                        leaves.add(neighbor);
                    }
                }

                graph.get(leaf).clear();
            }
        }

        return new ArrayList<>(leaves);
    }
}