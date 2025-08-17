class Solution {
    private void reverseCharArray(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;

        for (int i = 0; i <= n; i++) {
            if (i == n || chars[i] == ' ') {
                reverseCharArray(chars, start, i - 1);
                start = i + 1;
            }
        }

        return new String(chars);
    }
}