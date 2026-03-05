class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = (num * 10) + (c - '0');
            } else if (c == '+') {
                result += num * sign;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += num * sign;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += num * sign;
                num = 0;
                sign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + sign * result;
            }
        }

        result += num * sign;

        return result;
    }
}