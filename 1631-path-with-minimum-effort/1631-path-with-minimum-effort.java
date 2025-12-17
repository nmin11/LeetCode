class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] distance = new int[rows][cols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0];
            int row = cur[1];
            int col = cur[2];

            if (row == rows - 1 && col == cols - 1) return effort;

            if (effort > distance[row][col]) continue;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;

                int heightDiff = Math.abs(heights[newRow][newCol] - heights[row][col]);
                int newEffort = Math.max(effort, heightDiff);

                if (newEffort < distance[newRow][newCol]) {
                    distance[newRow][newCol] = newEffort;
                    pq.offer(new int[]{newEffort, newRow, newCol});
                }
            }
        }

        return 0;
    }
}