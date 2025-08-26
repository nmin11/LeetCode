class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') end--;

        int wordLength = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            wordLength++;
            end--;
        }

        return wordLength;
    }
}