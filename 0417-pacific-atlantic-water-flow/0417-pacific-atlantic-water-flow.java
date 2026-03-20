class Solution {
    private int n, m;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacificVisited, i, 0);
        }
        
        for (int j = 0; j < n; j++) {
            dfs(heights, pacificVisited, 0, j);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, atlanticVisited, i, n - 1);
        }
        
        for (int j = 0; j < n; j++) {
            dfs(heights, atlanticVisited, m - 1, j);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        if (visited[i][j]) return;

        visited[i][j] = true;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && heights[newI][newJ] >= heights[i][j]) {
                dfs(heights, visited, newI, newJ);
            }
        }
    }
}