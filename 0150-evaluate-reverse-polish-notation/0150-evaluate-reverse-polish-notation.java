class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int last = stack.pop();
                stack.push(stack.pop() - last);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int last = stack.pop();
                stack.push(stack.pop() / last);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}