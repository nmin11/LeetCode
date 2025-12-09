class Solution {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.fill(inDegree, -1);

        int[] candidate1 = null;
        int[] candidate2 = null;

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (inDegree[v] != -1) {
                candidate1 = edges[inDegree[v]];
                candidate2 = edges[i];
                break;
            }

            inDegree[v] = i;
        }

        for (int[] edge : edges) {
            if (candidate2 != null && edge == candidate2) continue;

            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v)) {
                if (candidate1 != null) {
                    return candidate1;
                } else {
                    return edge;
                }
            }

            union(u, v);
        }

        return candidate2;
    }
}