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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) count++;
        }

        return count;
    }
}