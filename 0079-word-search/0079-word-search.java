class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] == '#') return false;
        if (board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        char tmp = board[row][col];
        board[row][col] = '#';

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (dfs(board, word, nr, nc, index + 1)) {
                board[row][col] = tmp;
                return true;
            }
        }

        board[row][col] = tmp;

        return false;
    }
}