class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int last = stack.pop();
                int sum = last + stack.peek();
                stack.push(last);
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        while (!stack.isEmpty()) result += stack.pop();

        return result;
    }
}