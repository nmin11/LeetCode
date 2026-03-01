class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            int num = c - 'A' + 1;
            result = result * 26 + num;
        }

        return result;
    }
}