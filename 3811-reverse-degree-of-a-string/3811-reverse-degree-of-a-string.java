class Solution {
    private int getReverseDegree(char c) {
        return 26 - (c - 'a');
    }

    public int reverseDegree(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            result += getReverseDegree(chars[i]) * (i + 1);
        }

        return result;
    }
}