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

        reverseCharArray(chars, 0, n - 1);

        int wordEnd = 0;
        for (int i = 0; i < n;) {
            while (i < n && chars[i] == ' ') i++;

            if (i == n) break;

            if (wordEnd > 0) chars[wordEnd++] = ' ';

            int wordStart = wordEnd;

            while (i < n && chars[i] != ' ') {
                chars[wordEnd++] = chars[i++];
            }

            reverseCharArray(chars, wordStart, wordEnd - 1);
        }

        return new String(chars, 0, wordEnd);
    }
}