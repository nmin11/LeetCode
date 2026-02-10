class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));

        if (numRows == 1) return result;

        result.add(new ArrayList<>(Arrays.asList(1, 1)));

        if (numRows == 2) return result;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> preRow = result.get(i - 2);
            curRow.add(1);

            for (int j = 1; j < i - 1; j++) {
                curRow.add(preRow.get(j - 1) + preRow.get(j));
            }

            curRow.add(1);
            result.add(curRow);
        }

        return result;
    }
}