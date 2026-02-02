class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1];

            for (int[] dir : dirs) {
                int dr = row + dir[0];
                int dc = col + dir[1];

                if (dr >= 0 &&
                    dr < mat.length &&
                    dc >= 0 &&
                    dc < mat[0].length &&
                    result[dr][dc] > result[row][col] + 1) {
                    result[dr][dc] = result[row][col] + 1;
                    queue.offer(new int[]{dr, dc});
                }
            }
        }

        return result;
    }
}