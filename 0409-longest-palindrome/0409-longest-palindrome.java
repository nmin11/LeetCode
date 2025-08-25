class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128];
        int result = 0;
        boolean isOdd = false;

        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        for (int count : charCount) {
            if (count % 2 == 0) result += count;
            else {
                result += count - 1;
                isOdd = true;
            }
        }

        if (isOdd) result += 1;

        return result;
    }
}