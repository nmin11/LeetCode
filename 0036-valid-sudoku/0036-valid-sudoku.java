class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                
                if (c == '.') continue;

                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows.get(i).contains(c)) return false;
                if (cols.get(j).contains(c)) return false;
                if (boxes.get(boxIndex).contains(c)) return false;

                rows.get(i).add(c);
                cols.get(j).add(c);
                boxes.get(boxIndex).add(c);
            }
        }

        return true;
    }
}