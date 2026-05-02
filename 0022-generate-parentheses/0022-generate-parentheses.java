class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        String cur = "";
        List<String> result = new ArrayList<>();

        dfs(open, close, cur, result);

        return result;
    }

    private void dfs(int open, int close, String cur, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(cur);
        } else {
            if (open > 0) {
                dfs(open - 1, close, cur + "(", result);
            }

            if (close > open) {
                dfs(open, close - 1, cur + ")", result);
            }
        }
    }
}