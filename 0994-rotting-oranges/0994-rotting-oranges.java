class Solution {
    public int orangesRotting(int[][] grid) {
        int minute = 0;
        int freshCount = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) freshCount++;
            }
        }

        while (!queue.isEmpty()) {
            boolean hasRotten = false;;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] rottenOrange = queue.poll();
                int row = rottenOrange[0];
                int col = rottenOrange[1];

                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                        continue;
                    }

                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        hasRotten = true;
                    }
                }
            }

            if (hasRotten) minute++;
        }

        if (freshCount > 0) return -1;

        return minute;
    }
}