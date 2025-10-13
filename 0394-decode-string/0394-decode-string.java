class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();
        int curNum = 0;
        String curStr = "";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(curNum);
                stringStack.push(curStr);

                curNum = 0;
                curStr = "";
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                String prevStr = stringStack.pop();

                String repeated = curStr.repeat(repeatCount);
                curStr = prevStr + repeated;
            } else {
                curStr += c;
            }
        }

        return curStr;
    }
}