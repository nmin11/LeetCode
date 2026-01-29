class Solution {
    private void dfs(int[][] image, int row, int col, int from, int to) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }

        if (image[row][col] != from) return;

        image[row][col] = to;

        dfs(image, row - 1, col, from, to);
        dfs(image, row + 1, col, from, to);
        dfs(image, row, col - 1, from, to);
        dfs(image, row, col + 1, from, to);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int from = image[sr][sc];

        if (from == color) return image;

        dfs(image, sr, sc, from, color);

        return image;
    }
}