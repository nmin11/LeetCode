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
                result += sum;
            } else if (op.equals("D")) {
                int score = stack.peek() * 2;
                stack.push(score);
                result += score;
            } else if (op.equals("C")) {
                result -= stack.pop();
            } else {
                int num = Integer.parseInt(op);
                stack.push(num);
                result += num;
            }
        }

        return result;
    }
}