class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int result = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result = Math.max(result, dfs(r, c, matrix, memo));
            }
        }

        return result;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 ||
                nr >= matrix.length ||
                nc < 0 ||
                nc >= matrix[0].length ||
                matrix[row][col] >= matrix[nr][nc]
            ) continue;

            max = Math.max(max, dfs(nr, nc, matrix, memo));
        }

        memo[row][col] = 1 + max;

        return memo[row][col];
    }
}