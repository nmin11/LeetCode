class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(0);
            else {
                int cur = stack.pop();
                int score = (cur == 0) ? 1 : cur * 2;
                int prev = stack.pop();
                stack.push(prev + score);
            }
        }

        return stack.pop();
    }
}