class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] result = new int[isWater.length][isWater[0].length];

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                } else {
                    result[i][j] = -1;
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
                    dr < isWater.length &&
                    dc >= 0 &&
                    dc < isWater[0].length &&
                    result[dr][dc] == -1) {
                    result[dr][dc] = result[row][col] + 1;
                    queue.offer(new int[]{dr, dc});
                }
            }
        }

        return result;
    }
}